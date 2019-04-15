$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/casos_de_testes/loja/Login.feature");
formatter.feature({
  "name": "Logar cliente",
  "description": "  Loga um cliente no sistema",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Automacao"
    },
    {
      "name": "@Loja"
    },
    {
      "name": "@LoginLoja"
    },
    {
      "name": "@JonatasKirsch"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Login valido",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "o usuario acessou a pagina de login",
  "keyword": "Given "
});
formatter.step({
  "name": "digitar o email \"\u003cemail\u003e\" e a senha \"\u003csenha\u003e\" no login",
  "keyword": "When "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "email",
        "senha"
      ]
    },
    {
      "cells": [
        "teste.cadastro@mailcatch.com",
        "123456"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Login valido",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Automacao"
    },
    {
      "name": "@Loja"
    },
    {
      "name": "@LoginLoja"
    },
    {
      "name": "@JonatasKirsch"
    }
  ]
});
formatter.step({
  "name": "o usuario acessou a pagina de login",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "digitar o email \"teste.cadastro@mailcatch.com\" e a senha \"123456\" no login",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});