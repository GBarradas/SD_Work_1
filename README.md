Uma associação de estudantes precisa de um novo sistema para gerir os anúncios de quartos para arrendar, e
também as respetivas solicitações/procura. O seu trabalho é implementar as aplicações servidor, cliente geral e
cliente de gestão que permitam, desde as mais variadas localizações, o acesso ao serviço.
Cada anúncio terá localização, preço, género, data, anunciante, tipologia (quarto, T0, T1…), e poderá ser de oferta
de alojamento, ou de procura. Tem ainda um estado (inativo, ativo). Os dados devem ser guardados numa BD, no
servidor. Deve ser possível:
- Cliente geral:
    - registar novo anúncio do tipo oferta, ou do tipo procura, sendo que o anúncio fica em estado inativo
até ser aprovado pelo gestor, e atribui-lhe um novo código único, que será devolvido como resultado
da operação
    - listar anúncios (com estado ativo) do tipo oferta (com filtros opcionais por preço, género e
localização)
    - listar anúncios (com estado ativo) do tipo procura (com filtros opcionais por preço, género e
localização)
    - listar todos os anúncios de um anunciante
    - obter todos os detalhes de um anúncio, dado o seu identificador (aid)
    - enviar nova mensagem ao anunciante de um anúncio, pelo identificador aid
    - consultar as mensagens inseridas para um determinado anúncio
- Cliente de gestão
    - listar anúncios por estado
    - obter detalhes de um anúncio
    - aprovar um anúncio, alterando o estado do mesmo para ativo
    - alterar o estado de um anúncio.  

Procure, tanto quanto possível, abstrair-se dos detalhes de comunicação e das diferenças de plataforma entre
cliente e servidor, usando uma solução de Middleware mencionada nas aulas.  

Não se preocupe com a interface visual. Pode funcionar tudo pela linha de comandos, num menu simples. Não
precisa (ainda) preocupar-se com autenticação dos utilizadores do sistema de anúncios.  

Quaisquer parâmetros de configuração devem estar fora do código, sendo passados como argumento à aplicação
ou lidos de um ficheiro de propriedades (ver java.util.Properties).  

A solução implementada deve ser compatível com a plataforma de alunos.di.uevora.pt, tendo neste servidor
uma BD em Postgres de um dos elementos do grupo para registar os dados do serviço.   

### Nota: 17
[codigo](https://github.com/GBarradas/SD_Work_1)