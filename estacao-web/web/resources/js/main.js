const chuvaForte = 100;
const chuvaLeve = 500;
const diaNublado = 700;
const diaEnsolarado = 1000;

let graficoTemp;
let graficoUmi;

const spanTemp = document.getElementById("temperatura");
const spanUmi = document.getElementById("umidade");
const spanChuva = document.getElementById("precipitacao");

const reajustarGraficos = () => {
  graficoTemp.chart.data.datasets[0].data.shift();
  graficoTemp.chart.data.labels.shift();
  graficoUmi.chart.data.datasets[0].data.shift();
  graficoUmi.chart.data.labels.shift();
};

const adicionarMedidas = (medidas) => {
  graficoTemp.chart.data.labels.push(medidas.hora);
  graficoTemp.chart.data.datasets[0].data.push(medidas.temperatura);
  graficoUmi.chart.data.labels.push(medidas.hora);
  graficoUmi.chart.data.datasets[0].data.push(medidas.umidade);

  graficoTemp.chart.update();
  spanTemp.innerHTML = medidas.temperatura;
  graficoUmi.chart.update();
  spanUmi.innerHTML = medidas.umidade;
  
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
      graficoUmi = PF("ghumi");
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
  if (precipitacao > 500) {
    climaSvg.src = imagemSol;
    clima.innerHTML = "Sol";
    pararChuva();
  }
  else {
    climaSvg.src = imagemChuva;
    clima.innerHTML = "Chuva";
    fazerChover();
  }
  spanChuva.innerHTML = precipitacao;
};

document.addEventListener("DOMContentLoaded", () => {
  configurarDarkMode();
  conectarWebSocket();
});
