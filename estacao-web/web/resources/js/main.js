const data = [0]
const categories = ['']

const chuvaLeve = 500
const chuvaFort = 100
const diaNublado = 600
const diaEnsolarado = 1000

var options = {
  series: [{
  name: 'temp',
  data: [...data]
}],
  chart: {
  id: 'realtime',
  height: 350,
  type: 'line',
  animations: {
    enabled: true,
    easing: 'linear',
    dynamicAnimation: {
      speed: 1000
    }
  },
  toolbar: {
    show: false
  },
  zoom: {
    enabled: true
  }
},
dataLabels: {
  enabled: false
},
stroke: {
  curve: 'smooth'
},
title: {
  text: 'Gráfico Temperatura',
  align: 'left'
},
markers: {
  size: 0
},
xaxis: {
  range: 10,
  categories: [...categories]
},
yaxis: {
  max: 100
},
legend: {
  show: false
},
};

const chart = new ApexCharts(document.querySelector("#graficoTemp"), options);
chart.render();

function getNewSeries(min, max) {
  const date = new Intl.DateTimeFormat('pt-br', {
    hour: '2-digit',
    minute: '2-digit',
    second: "2-digit",
  }).format(new Date())

  categories.push(date)
  const temp = Math.floor(Math.random() * (Math.floor(max) - Math.ceil(min)) + min)
  data.push(temp)
}


function changeDataChart() {
  getNewSeries(10, 90)

}

window.addEventListener("DOMContentLoaded", () => {
  setInterval(() => {
    changeDataChart()
    console.log('aqui')
    chart.updateSeries([{
      data: [...data]
    }])
    chart.updateOptions({
      xaxis: {
        categories: [...categories]
      }
    })
  }, 1000)
})


const buttondarkMode = document.querySelector('#backgroundChange');

buttondarkMode.addEventListener('click', ()=>{
  let currentTheme = document.body.getAttribute("data-theme");
  let targetTheme = "light";

  if (currentTheme === "light") {
        targetTheme = "dark";
  }
  document.body.setAttribute('data-theme', targetTheme)
}) 

const rainingSvg = document.querySelector('.raining')
const clima = document.querySelector('.clima')

const checkIfIsRaining = () => {
  const rainMeter = 400
  if(rainMeter >= 500) {
    rainingSvg.src = imagemChuva;
    clima.innerHTML =  'Chuva leve'
  }
  
  rainingSvg.src = imagemSol;
}

checkIfIsRaining()


  