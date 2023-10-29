const ctnChuva = document.querySelector(".container-chuva");

let chovendo = false;

function pararChuva() {
  chovendo = false;
  ctnChuva.innerHTML = "";
}

function fazerChover() {
  if (chovendo) return;
  for (let posX = 5; posX <= 95; posX += 5 ) {
    const delay = Math.floor(Math.random() * 100) + 1;
    const pingo = document.createElement("div");
    pingo.classList.add("pingo");
    pingo.style.left = `${posX}%`;
    pingo.style.animationDelay = `0.${delay}s`;
    ctnChuva.appendChild(pingo);
  }
  chovendo = true;
}