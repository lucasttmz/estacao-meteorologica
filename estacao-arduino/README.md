# 🌡️ Estação Arduino

Aplicação utilizada para ler a temperatura, humidade e precipitação com o Arduino e salvar essas medidas no banco de dados.

## ❄️ Visão geral

- **Leitura de Temperatura**: O Arduino coleta dados de temperatura usando sensores específicos e registra-os no banco de dados.

- **Medição de Umidade**: Sensores de umidade são usados para coletar informações sobre a umidade do ambiente e armazená-las para referência futura.

- **Registro de Precipitação**: A aplicação é capaz de detectar e registrar eventos de precipitação, fornecendo informações importantes para análises climáticas.

- **Banco de Dados**: Todos os dados coletados são armazenados em um banco de dados, para que possam ser lidos através da [Estação Web](../estacao-web/).

## 📡 Sensores e Microcontroladores

- **DHT11**: Humidade e Temperatura

- **MH-RD**: Precipitação 

## 🔧 Dependências
- [JSerialComm 2.10.3](https://fazecast.github.io/jSerialComm/)
- [Hibernate](https://hibernate.org)


</br>

*[Voltar a página inicial do projeto](../)*