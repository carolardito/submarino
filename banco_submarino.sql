CREATE TABLE produto (
    cod_produto INT not null primary key
        GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
    nome_produto VARCHAR(50) not null,
    preco DOUBLE not null,
    descricao VARCHAR(10)
);

CREATE TABLE item (
    cod_item INT not null primary key
        GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
    cod_produto INT not null ,
    quantidade INT not null,
    FOREIGN KEY (cod_produto) REFERENCES submarino.produto(cod_produto)
    
);

CREATE TABLE ceps (
    cep INT not null primary key,
    preco DOUBLE not null    
);

    
CREATE TABLE carrinho (
     cod_carrinho INT not null primary key
        GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
     cep INT,
     FOREIGN KEY (cep) REFERENCES submarino.ceps(cep)
);

CREATE TABLE lista_item (
    cod_carrinho INT not null,
    cod_item INT not null,
    FOREIGN KEY (cod_item) REFERENCES submarino.item(cod_item),
    FOREIGN KEY (cod_carrinho) REFERENCES submarino.carrinho(cod_carrinho)
);
