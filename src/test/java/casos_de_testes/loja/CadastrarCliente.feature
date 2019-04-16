@Automacao @Loja @CadastroCliente @AndreMiranda @BrunoMacedo @CristinoWatanabe @FabioSantos @Pedro @Jomal

Feature: Cadastrar cliente
  Cadastrar um cliente no sistema

  Scenario Outline: Cadastro valido
    Given o usuario acessou a pagina de cadastro

    Examples:
      | firstName  |  lastName      |   Email               |
      | Name Test  |  Surname Test  |   email@cadastro.com  |
