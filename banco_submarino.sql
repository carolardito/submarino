CREATE TABLE produto (
    cod_produto INT not null primary key
        GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
    nome_produto VARCHAR(50) not null,
    preco DOUBLE not null,
    descricao VARCHAR(50)
);

CREATE TABLE ceps (
    cep varchar(8) not null primary key,
    preco DOUBLE not null    
);

    
CREATE TABLE carrinho (
     cod_carrinho INT not null primary key
        GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
     cep varchar (8),
     FOREIGN KEY (cep) REFERENCES ceps(cep)
);

CREATE TABLE item (    
    cod_carrinho int not null,
    cod_produto INT not null ,
    quantidade INT not null,
    primary key (cod_carrinho, cod_produto),
    FOREIGN KEY (cod_produto) REFERENCES produto(cod_produto),
    FOREIGN KEY (cod_carrinho) REFERENCES CARRINHO(cod_carrinho)    
    
);

