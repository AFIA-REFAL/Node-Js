import axios from "axios";

const API_KEY = "e2d00c175c6c86e742794e34b81bcf17";

/**
 * Fetch weather + return formatted chart data
 */
export const getWeatherChartData = async (city) => {
  try {
    const res = await axios.get(
      `https://api.openweathermap.org/data/2.5/forecast?q=${city}&appid=${API_KEY}&units=metric`
    );

    const data = res.data;

    const labels = data.list.slice(0, 8).map(item => item.dt_txt);
    const temps = data.list.slice(0, 8).map(item => item.main.temp);

    return {
      city: data.city.name,
      labels,
      temps,
    };

  } catch (error) {
    throw new Error("Weather fetch failed");
  }
};