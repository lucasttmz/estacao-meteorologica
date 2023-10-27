const ctnChuva = document.querySelector(".container-chuva");

function pararChuva() {
  ctnChuva.innerHTML = "";
}

function fazerChover() {
  for (let posX = 5; posX <= 95; posX += 5 ) {
    const delay = Math.floor(Math.random() * 100) + 1;
    const pingo = document.createElement("div");
    pingo.classList.add("pingo");
    pingo.style.left = `${posX}%`;
    pingo.style.animationDelay = `0.${delay}s`;
    ctnChuva.appendChild(pingo);
  }
}