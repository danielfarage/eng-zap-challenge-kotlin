Antes de rodar o projeto, sugiro rodar a task Clean.

# O Projeto

Usei clean architecture, separando view, viewModel, usecase, repository e data sources.
Usei retrofit com coroutines para recuperar os dados do endpoint e salvei no Room usando inMemory para trabalhar melhor os dados e Paging Library para paginar os dados no RecyclerView.
Para injeção de dependencia eu optei pelo Koin por ser mais prático.
Para testes unitários usei junit4 e mockk

Gostaria de ter tido mais tempo para fazer o teste integrado usando o Robot Pattern.
