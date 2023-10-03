CREATE DATABASE estacaoAPS;

USE estacaoAPS;

CREATE TABLE registro (
  cd_registro int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  umidade int(11) NOT NULL,
  temperatura int(11) NOT NULL,
  chuva int(11) NOT NULL,
  momento datetime NOT NULL
);