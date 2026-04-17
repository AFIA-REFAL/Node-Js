import React from "react";
import { Line } from "react-chartjs-2";
import {
  Chart as ChartJS,
  LineElement,
  CategoryScale,
  LinearScale,
  PointElement,
} from "chart.js";

ChartJS.register(LineElement, CategoryScale, LinearScale, PointElement);

const WeatherChart = ({ data }) => {
  if (!data) return null;

  const labels = data.list.slice(0, 8).map(x => x.dt_txt);
  const temps = data.list.slice(0, 8).map(x => x.main.temp);

  const chartData = {
    labels,
    datasets: [
      {
        label: "Temperature (°C)",
        data: temps,
        borderColor: "blue",
        backgroundColor: "rgba(0,0,255,0.2)",
        fill: true,
        tension: 0.3,
      },
    ],
  };

  return <Line data={chartData} />;
};

export default WeatherChart;