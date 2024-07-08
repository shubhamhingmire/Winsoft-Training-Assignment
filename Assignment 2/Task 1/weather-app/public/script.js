document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('city-form');
    const cityInput = document.getElementById('city-input');
    const cityElem = document.getElementById('city');
    const temperatureElem = document.getElementById('temperature');
    const descriptionElem = document.getElementById('description');

    form.addEventListener('submit', (event) => {
        event.preventDefault();
        const city = cityInput.value;
        const isLocal = window.location.hostname === 'localhost';
        const apiUrl = isLocal 
            ? `http://localhost:3000/weather` 
            : `https://api.openweathermap.org/data/2.5/weather?q=${city}&appid=e0d93b4d3255358f85a7169ce8f42934&units=metric`;

        console.log(`Fetching weather data from: ${apiUrl}`);

        fetch(apiUrl)
            .then(response => {
                console.log(`Response status: ${response.status}`);
                if (!response.ok) {
                    throw new Error(`HTTP error! Status: ${response.status}`);
                }
                return response.json();
            })
            .then(data => {
                console.log('Weather data received:', data);

                
                let weatherDescription;
                if (isLocal) {
                    
                    data = data[0];
                }
                
                const weather = data.weather[0];
                const main = data.main;
                weatherDescription = `
                    City: ${data.name}
                    Temperature: ${main.temp}°C
                    Feels Like: ${main.feels_like}°C
                    Min Temperature: ${main.temp_min}°C
                    Max Temperature: ${main.temp_max}°C
                    Pressure: ${main.pressure} hPa
                    Humidity: ${main.humidity}%
                    Description: ${weather.description.charAt(0).toUpperCase() + weather.description.slice(1)}
                    Wind Speed: ${data.wind.speed} m/s
                    Wind Gust: ${data.wind.gust || 'N/A'} m/s
                    Visibility: ${data.visibility} meters
                    Cloud Coverage: ${data.clouds.all}%
                    Country: ${data.sys.country}
                    Sunrise: ${new Date(data.sys.sunrise * 1000).toLocaleTimeString()}
                    Sunset: ${new Date(data.sys.sunset * 1000).toLocaleTimeString()}
                `;

                cityElem.innerText = data.name || 'N/A';
                temperatureElem.innerText = `${main.temp || 'N/A'}°C`;
                descriptionElem.innerText = weatherDescription;
            })
            .catch(error => console.error('Error fetching weather data:', error));
    });
});
