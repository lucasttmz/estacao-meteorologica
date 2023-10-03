let fazerChover = function() {
    document.querySelector('.rain').innerHTML='';
  
    var incremento = 0;
    var pingos = "";
    var pingosFundo = "";
  
    while (incremento < 100) {
      var max100 = (Math.floor(Math.random() * 98 + 1));
      var max5 = (Math.floor(Math.random() * 4 + 2));

      incremento += max5;
      pingos += '<div class="drop" style="left: ' + incremento + '%; bottom: ' + (max5 + max5 - 1 + 100) + '%; animation-delay: 0.' + max100 + 's; animation-duration: 0.5' + max100 + 's;"><div class="stem" style="animation-delay: 0.' + max100 + 's; animation-duration: 0.5' + max100 + 's;"></div><div class="splat" style="animation-delay: 0.' + max100 + 's; animation-duration: 0.5' + max100 + 's;"></div></div>';
      pingosFundo += '<div class="drop" style="right: ' + incremento + '%; bottom: ' + (max5 + max5 - 1 + 100) + '%; animation-delay: 0.' + max100 + 's; animation-duration: 0.5' + max100 + 's;"><div class="stem" style="animation-delay: 0.' + max100 + 's; animation-duration: 0.5' + max100 + 's;"></div><div class="splat" style="animation-delay: 0.' + max100 + 's; animation-duration: 0.5' + max100 + 's;"></div></div>';
        
    }

  
    document.querySelector('.rain').insertAdjacentHTML('afterbegin', pingos);
  };

  let pararChuva = () =>{
    document.querySelector('.rain').innerHTML='';
  };
