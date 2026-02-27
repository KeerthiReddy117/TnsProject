// script.js - Simple weather fetcher using OpenWeatherMap
// Requires config.js with OPENWEATHER_API_KEY variable

// --- DOM elements
const form = document.getElementById('searchForm');
const cityInput = document.getElementById('cityInput');
const statusEl = document.getElementById('status');
const weatherCard = document.getElementById('weatherCard');
const locationEl = document.getElementById('location');
const descEl = document.getElementById('description');
const iconWrap = document.getElementById('iconWrap');
const tempEl = document.getElementById('temp');
const feelsEl = document.getElementById('feelsLike');
const humidityEl = document.getElementById('humidity');
const windEl = document.getElementById('wind');
const cloudsEl = document.getElementById('clouds');
const unitToggle = document.getElementById('unitToggle');
const geoBtn = document.getElementById('geoBtn');

let useFahrenheit = false;

// --- safety: check API key
if (typeof OPENWEATHER_API_KEY === 'undefined' || !OPENWEATHER_API_KEY || OPENWEATHER_API_KEY.includes('YOUR_')) {
  setStatus('ERROR: Missing or placeholder API key. Create config.js with your OpenWeatherMap API key.', true);
  // Do not halt script — allow user to put key and reload
}

// --- event listeners
unitToggle.addEventListener('change', () => {
  useFahrenheit = unitToggle.checked;
  const lat = locationEl.dataset.lat;
  const lon = locationEl.dataset.lon;
  const city = locationEl.dataset.city;
  if (lat && lon) {
    fetchWeatherByCoords(lat, lon, locationEl.textContent);
  } else if (city) {
    fetchWeatherByCity(city);
  }
});

form.addEventListener('submit', (e) => {
  e.preventDefault();
  const city = cityInput.value.trim();
  if (!city) return;
  fetchWeatherByCity(city);
});

geoBtn.addEventListener('click', () => {
  if (!navigator.geolocation) {
    setStatus('Geolocation not supported by your browser.', true);
    return;
  }
  setStatus('Getting your location…');
  navigator.geolocation.getCurrentPosition(
    (pos) => fetchWeatherByCoords(pos.coords.latitude, pos.coords.longitude),
    (err) => setStatus('Unable to get location. ' + err.message, true)
  );
});

// --- helpers
function setStatus(msg, isError=false) {
  statusEl.textContent = msg;
  statusEl.style.color = isError ? 'crimson' : '';
}

function showCard() { weatherCard.classList.remove('hidden'); }
function hideCard() { weatherCard.classList.add('hidden'); }

function capitalize(s) {
  return s ? s.charAt(0).toUpperCase() + s.slice(1) : '';
}

// --- fetch by city name (uses geocoding to get lat/lon)
async function fetchWeatherByCity(city) {
  if (!OPENWEATHER_API_KEY) {
    setStatus('No API key. Add your key to config.js', true);
    return;
  }
  setStatus('Loading weather for ' + city + '…');
  hideCard();
  try {
    const geoResp = await fetch(`https://api.openweathermap.org/geo/1.0/direct?q=${encodeURIComponent(city)}&limit=1&appid=${OPENWEATHER_API_KEY}`);
    if (!geoResp.ok) throw new Error('Geocoding API error: ' + geoResp.status);
    const geoData = await geoResp.json();
    if (!geoData || !geoData.length) {
      setStatus('City not found.', true);
      return;
    }
    const { lat, lon, name, country } = geoData[0];
    locationEl.dataset.city = name;
    locationEl.dataset.lat = lat;
    locationEl.dataset.lon = lon;
    fetchWeatherByCoords(lat, lon, `${name}, ${country}`);
  } catch (err) {
    console.error(err);
    setStatus('Error fetching location data: ' + err.message, true);
  }
}

// --- fetch by coordinates
async function fetchWeatherByCoords(lat, lon, prettyName) {
  if (!OPENWEATHER_API_KEY) {
    setStatus('No API key. Add your key to config.js', true);
    return;
  }
  setStatus('Loading weather…');
  hideCard();
  const units = useFahrenheit ? 'imperial' : 'metric';
  try {
    const res = await fetch(`https://api.openweathermap.org/data/2.5/weather?lat=${lat}&lon=${lon}&appid=${OPENWEATHER_API_KEY}&units=${units}`);
    if (!res.ok) {
      if (res.status === 401) throw new Error('Unauthorized — check your API key.');
      throw new Error('Weather API error: ' + res.status);
    }
    const data = await res.json();

    // Populate UI
    const name = prettyName || `${data.name}, ${data.sys.country}`;
    locationEl.textContent = name;
    locationEl.dataset.city = data.name;
    locationEl.dataset.lat = lat;
    locationEl.dataset.lon = lon;

    const desc = data.weather && data.weather[0] ? capitalize(data.weather[0].description) : '—';
    descEl.textContent = desc;
    tempEl.textContent = `${Math.round(data.main.temp)}° ${useFahrenheit ? 'F' : 'C'}`;
    feelsEl.textContent = `Feels like ${Math.round(data.main.feels_like)}°`;
    humidityEl.textContent = data.main.humidity;
    windEl.textContent = `${data.wind.speed}`;
    cloudsEl.textContent = data.clouds.all;

    // Icon
    const iconCode = data.weather && data.weather[0] ? data.weather[0].icon : null;
    if (iconCode) {
      const img = document.createElement('img');
      img.alt = desc;
      img.src = `https://openweathermap.org/img/wn/${iconCode}@2x.png`;
      iconWrap.innerHTML = '';
      iconWrap.appendChild(img);
    } else {
      iconWrap.innerHTML = '';
    }

    setStatus('Updated: ' + new Date().toLocaleTimeString());
    showCard();
  } catch (err) {
    console.error(err);
    setStatus('Failed to fetch weather: ' + err.message, true);
  }
}

// Optional: prefill with a default city for first load (comment out if you don't want this)
fetchWeatherByCity('New Delhi');
