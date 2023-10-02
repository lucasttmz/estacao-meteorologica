const chuvaForte = 100;
const chuvaLeve = 500;
const diaNublado = 700;
const diaEnsolarado = 1000;

let graficoTemp;
let graficoHumi;

const spanTemp = document.getElementById("temperatura");
const spanHumi = document.getElementById("humidade");
const spanChuva = document.getElementById("precipitacao");

const reajustarGraficos = () => {
  graficoTemp.chart.data.datasets[0].data.shift();
  graficoTemp.chart.data.labels.shift();
  graficoHumi.chart.data.datasets[0].data.shift();
  graficoHumi.chart.data.labels.shift();
};

const adicionarMedidas = (medidas) => {
  graficoTemp.chart.data.labels.push(medidas.hora);
  graficoTemp.chart.data.datasets[0].data.push(medidas.temperatura);
  graficoHumi.chart.data.labels.push(medidas.hora);
  graficoHumi.chart.data.datasets[0].data.push(medidas.humidade);

  graficoTemp.chart.update();
  spanTemp.innerHTML = parseFloat(medidas.temperatura).toFixed(1);
  graficoHumi.chart.update();
  spanHumi.innerHTML = parseFloat(medidas.humidade).toFixed(1);
  
  checarSeEstaChuvendo(medidas.precipitacao);
};

const conectarWebSocket = () => {
  const url = "ws://" + window.location.host + "/estacao-web/ws";
  const socket = new WebSocket(url);
  const suportado = "WebSocket" in window;
  let qtdDados = 0;

  if (suportado) {
    socket.onopen = async () => console.log("WebSocket conectado!");
    socket.onmessage = async (event) => {
      let medidas = JSON.parse(event.data);
      graficoTemp = PF("gtemp");
      graficoHumi = PF("ghumi");
      if (qtdDados === 5) {
        reajustarGraficos();
      } else {
        qtdDados++;
      }
      adicionarMedidas(medidas);
    };
    socket.onclose = async () => console.log("WebSocket desconectado...");
  } else {
    alert("WebSocket não é suportado pelo seu navegador!");
  }
};

const configurarDarkMode = () => {
  const btnDarkMode = document.querySelector('#frmTema-backgroundChange');
  btnDarkMode.addEventListener('click', () => {
    let temaAtual = document.body.getAttribute("data-theme");
    let novoTema = "light";

    if (temaAtual === "light") {
      novoTema = "dark";
    }
    document.body.setAttribute('data-theme', novoTema);
  });
};

const climaSvg = document.querySelector('.climaImg');
const clima = document.querySelector('.clima');

const checarSeEstaChuvendo = (precipitacao) => {
  if (precipitacao >= 1000) {
    climaSvg.src = imagemSol;
    clima.innerHTML = "Dia Ensolarado";
    stopItRain();
  } 
  else if (precipitacao >= 700) {
    climaSvg.src = imagemSol;
    clima.innerHTML = "Dia Nublado";
    stopItRain();
  }
  else if (precipitacao >= 500) {
    climaSvg.src = imagemChuva;
    clima.innerHTML = "Chuva Leve";
    makeItRain();
  }
  else {
    climaSvg.src = imagemChuva;
    clima.innerHTML = "Chuva Forte";
    makeItRain();
  }
  spanChuva.innerHTML = precipitacao;
};

document.addEventListener("DOMContentLoaded", () => {
  configurarDarkMode();
  conectarWebSocket();
});
