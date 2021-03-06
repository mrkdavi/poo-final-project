



-- Pessoa -> log_interação
create or replace function pessoa_log_interacao_func()
returns trigger as $BODY$
	begin
		if(TG_OP = 'UPDATE') THEN
			update pessoa set nome = new.nome,
							  data_nasc = new.data_nasc,
							  cpf = new.cpf,
							  login = new.login,
							  senha = new.senha,
							  tipo = new.tipo,
							  id_endereco = new.id_endereco
			where cpf = old.cpf;
			if not found then return null; end if;

			NEW.last_updated = now();
			
			UPDATE LOG_INTERACAO SET login_pessoa = NEW.login 
			where login_pessoa = old.login;
			
			return new;
		ELSIF(TG_OP = 'DELETE') THEN
			DELETE FROM pessoa where cpf = old.cpf;
			if not found then return null; end if;

			OLD.last_updated = now();

			delete from log_interacao
			where login_pessoa = old.login;
			return old;
		end if;

	END;
$BODY$ LANGUAGE plpgsql;



-- Pessoa -> estagiario
create or replace function pessoa_estagiario_func()
returns trigger as $BODY$
	begin
		if(TG_OP = 'UPDATE') then
			update pessoa set nome = new.nome,
							  data_nasc = new.data_nasc,
							  cpf = new.cpf,
							  login = new.login,
							  senha = new.senha,
							  tipo = new.tipo,
							  id_endereco = new.id_endereco
			where cpf = old.cpf;
			if not found then return null; end if;

			NEW.last_updated = now();
			
			update estagiario set cpf = new.cpf
			where cpf = old.cpf;

			return new;
		elsif(TG_OP = 'DELETE') then
			DELETE FROM pessoa where cpf = old.cpf;
			if not found then return null; end if;

			OLD.last_updated = now();
			
			delete from estagiario where cpf = old.cpf;
			return old;
		end if;

	END;
$BODY$ language plpgsql;



--Pessoa ->funcionario
create or replace function pessoa_funcionario_func()
returns trigger as $BODY$
	begin
		if(TG_OP = 'UPDATE') then
			update pessoa set nome = new.nome,
							  data_nasc = new.data_nasc,
							  cpf = new.cpf,
							  login = new.login,
							  senha = new.senha,
							  tipo = new.tipo,
							  id_endereco = new.id_endereco
			where cpf = old.cpf;
			if not found then return null; end if;

			NEW.last_updated = now();
			
			update funcionario set cpf = new.cpf
			where cpf = old.cpf;
			return new;
		elsif(TG_OP = 'DELETE') then
			DELETE FROM pessoa where cpf = old.cpf;
			if not found then return null; end if;

			OLD.last_updated = now();
			
			delete from funcionario where cpf = old.cpf;
			
			return old;
		end if;

	END;
$BODY$ language plpgsql;



-- Pessoa -> dono
create or replace function pessoa_dono_func()
returns trigger as $BODY$
	begin
		if(TG_OP = 'UPDATE') then
			update pessoa set nome = new.nome,
							  data_nasc = new.data_nasc,
							  cpf = new.cpf,
							  login = new.login,
							  senha = new.senha,
							  tipo = new.tipo,
							  id_endereco = new.id_endereco
			where cpf = old.cpf;
			if not found then return null; end if;

			NEW.last_updated = now();
			
			update dono set cpf = new.cpf
			where cpf = old.cpf;
			
			return new;
		elsif(TG_OP = 'DELETE') then
			DELETE FROM pessoa where cpf = old.cpf;
			if not found then return null; end if;

			OLD.last_updated = now();
			
			delete from dono where cpf = old.cpf;
			
			return old;
		end if;

	END;
$BODY$ language plpgsql;


-- Pessoa -> endereco
create or replace function pessoa_endereco_func()
returns trigger as $BODY$
	begin
		if(TG_OP = 'UPDATE') then
			update pessoa set nome = new.nome,
							  data_nasc = new.data_nasc,
							  cpf = new.cpf,
							  login = new.login,
							  senha = new.senha,
							  tipo = new.tipo,
							  id_endereco = new.id_endereco
			where cpf = old.cpf;
			if not found then return null; end if;

			NEW.last_updated = now();
			
			if (new.id_endereco != old.id_endereco) then
				delete from endereco
				where id = old.id_endereco;
			end if;
			
			return new;
		elsif(TG_OP = 'DELETE') then
			DELETE FROM pessoa where cpf = old.cpf;
			if not found then return null; end if;

			OLD.last_updated = now();
			
			delete from endereco where id = old.id_endereco;
			
			return old;
		end if;

	END;
$BODY$ language plpgsql;

-- empresa -> categoria

create or replace function empresa_categoria_func()
returns trigger as $BODY$
begin
	if(TG_OP = 'UPDATE') then 
		UPDATE empresa SET orcamento = new.orcamento,
							  cnpj = new.cnpj,
							  nome = new.nome,
							  cpf_dono = new.cpf_dono
		WHERE cnpj = OLD.cnpj;
		
		if not found then return null; end if;
		
		NEW.last_updated = now();
		
		update categoria set cnpj_empresa = new.cnpj
		where cnpj_empresa = old.cnpj;
		return new;
	elsif(TG_OP = 'DELETE') then
		delete from empresa
		where cnpj = old.cnpj;
		
		if not found then return null; end if;
		
		OLD.last_updated = now();
		
		delete from categoria
		where cnpj_empresa = old.cnpj;
		return old;
	end if;
end;
$BODY$ language plpgsql;



-- categoria -> diretor
create or replace function categoria_diretor_func()
returns trigger as $BODY$
	begin
		if(TG_OP = 'UPDATE') then
			update categoria set nome = new.nome,
								 id = new.id,
								 carga_horaria = new.carga_horaria,
								 descricao = new.descricao,
								 salario = new.salario,
								 cnpj_empresa = new.cnpj_empresa
			where id = old.id;

			if not found then return null; end if;

			NEW.last_updated = now();

			update diretor set id_categoria = new.id
			where id_categoria = old.id;
			return new;
		elsif(TG_OP = 'DELETE')then
			delete from categoria 
			where id = old.id;
			
			if not found then return null; end if;
		
			OLD.last_updated = now();
			
			delete from diretor
			where id_categoria = old.id;
			return old;
		end if;


	END;
$BODY$ language plpgsql;



-- categoria -> estagiario
create or replace function categoria_estagiario_func()
returns trigger as $BODY$
	begin
		if(TG_OP = 'UPDATE') then
			update categoria set nome = new.nome,
								 id = new.id,
								 carga_horaria = new.carga_horaria,
								 descricao = new.descricao,
								 salario = new.salario,
								 cnpj_empresa = new.cnpj_empresa
			where id = old.id;

			if not found then return null; end if;

			NEW.last_updated = now();

			update estagiario set id_categoria = new.id
			where id_categoria = old.id;
			return new;
		elsif(TG_OP = 'DELETE')then
			delete from categoria 
			where id = old.id;
			
			if not found then return null; end if;
		
			OLD.last_updated = now();
			
			delete from estagiario
			where id_categoria = old.id;
			return old;
		end if;

	END;
$BODY$ language plpgsql;

-- categoria -> funcionario
create or replace function categoria_funcionario_func()
returns trigger as $BODY$
	begin
		if(TG_OP = 'UPDATE') then
			update categoria set nome = new.nome,
								 id = new.id,
								 carga_horaria = new.carga_horaria,
								 descricao = new.descricao,
								 salario = new.salario,
								 cnpj_empresa = new.cnpj_empresa
			where id = old.id;

			if not found then return null; end if;

			NEW.last_updated = now();

			update funcionario set id_categoria = new.id
			where id_categoria = old.id;
			return new;

		elsif(TG_OP = 'DELETE')then

			delete from categoria 
			where id = old.id;
			
			if not found then return null; end if;
		
			OLD.last_updated = now();
			
			delete from funcionario
			where id_categoria = old.id;
			return old;
		end if;

	END;
$BODY$ language plpgsql;


-- bairro -> endereco
create or replace function bairro_endereco_func()
returns trigger as $BODY$
	begin
		if(TG_OP = 'UPDATE') then
			update bairro set nome = new.nome,
								 id = new.id,
								 id_cidade = new.id_cidade
			where id = old.id;

			if not found then return null; end if;

			NEW.last_updated = now();

			update endereco set id_bairro = new.id
			where id_bairro = old.id;
			return new;
		elsif(TG_OP = 'DELETE')then
			delete from bairro 
			where id = old.id;
			
			if not found then return null; end if;
		
			OLD.last_updated = now();
			
			delete from endereco
			where id_bairro = old.id;

			return old;
		end if;

	END;
$BODY$ language plpgsql;


-- cidade -> bairro
create or replace function cidade_bairro_func()
returns trigger as $BODY$
	begin
		if(TG_OP = 'UPDATE') then
			update cidade set nome = new.nome,
								 id = new.id,
								 uf = new.uf
			where id = old.id;

			if not found then return null; end if;

			NEW.last_updated = now();

			update bairro set id_cidade = new.id
			where id_cidade = old.id;
			return new;
		elsif(TG_OP = 'DELETE')then
			delete from cidade 
			where id = old.id;
			
			if not found then return null; end if;
		
			OLD.last_updated = now();
			
			delete from bairro
			where id_cidade = old.id;
			return old;
		end if;

	END;
$BODY$ language plpgsql;


----------------------------------------------------------------------



-- select * from pessoa
-- select * from diretor
-- Pessoa -> diretor

CREATE OR REPLACE FUNCTION PESSOA_DIRETOR_FUNC()
RETURNS TRIGGER AS
$$
	BEGIN
        IF(TG_OP = 'UPDATE') THEN
            UPDATE pessoa SET nome = new.nome,
                            data_nasc = new.data_nasc,
                            cpf = new.cpf,
                            login = new.login,
                            senha = new.senha,
                            tipo = new.tipo,
                            id_endereco = new.id_endereco
            WHERE cpf = OLD.cpf;
            IF NOT FOUND THEN RETURN NULL; END IF;

            NEW.last_updated = now();
            
            UPDATE diretor SET cpf = NEW.cpf

            WHERE cpf = OLD.cpf;
            RETURN NEW;
		ELSIF (TG_OP = 'DELETE') THEN
            DELETE FROM pessoa WHERE cpf = OLD.cpf;
            IF NOT FOUND THEN RETURN NULL; END IF;
		
			OLD.last_updated = now();
			
            DELETE FROM diretor WHERE cpf = OLD.cpf;
            IF NOT FOUND THEN RETURN NULL; END IF;
                return old;
		END IF;

	END;
$$
LANGUAGE 'plpgsql';



-- select * from setor
-- select * from funcionario
-- setor -> funcionario

CREATE OR REPLACE FUNCTION SETOR_FUNCIONARIO_FUNC()
RETURNS TRIGGER AS
$$
	BEGIN
		IF(TG_OP = 'UPDATE') THEN
			UPDATE setor SET id = new.id,
						  nome = new.nome,
						  orcamento = new.orcamento,
						  cnpj_empresa = new.cnpj_empresa
			WHERE id = OLD.id;
			IF NOT FOUND THEN RETURN NULL; END IF;

			NEW.last_updated = now();

			UPDATE funcionario SET id_setor = NEW.id
			WHERE id_setor = OLD.id;
			RETURN NEW;
		ELSIF (TG_OP = 'DELETE') THEN
            DELETE FROM setor WHERE id = OLD.id;
            IF NOT FOUND THEN RETURN NULL; END IF;
		
			OLD.last_updated = now();
			
            DELETE FROM funcionario WHERE id_setor = OLD.id;
            IF NOT FOUND THEN RETURN NULL; END IF;
            return old;
		END IF;

	END;
$$
LANGUAGE 'plpgsql';



-- select * from setor
-- select * from gerencia
-- setor -> gerencia

CREATE OR REPLACE FUNCTION SETOR_GERENCIA_FUNC()
RETURNS TRIGGER AS
$$
	BEGIN
		IF(TG_OP = 'UPDATE') THEN
            UPDATE setor SET id = new.id,
                            nome = new.nome,
                            orcamento = new.orcamento,
                            cnpj_empresa = new.cnpj_empresa
            WHERE id = OLD.id;
            IF NOT FOUND THEN RETURN NULL; END IF;

            NEW.last_updated = now();
            
            UPDATE gerencia SET id_setor = NEW.id
            WHERE id_setor = OLD.id;
            RETURN NEW;
	
		ELSIF (TG_OP = 'DELETE') THEN
            DELETE FROM setor WHERE id = OLD.id;
            IF NOT FOUND THEN RETURN NULL; END IF;
		
			OLD.last_updated = now();
			
            DELETE FROM gerencia WHERE id_setor = OLD.id;
            IF NOT FOUND THEN RETURN NULL; END IF;
            return old;
		END IF;

	END;
$$
LANGUAGE 'plpgsql';



-- select * from setor
-- select * from estagiario
-- setor -> estagiario

CREATE OR REPLACE FUNCTION SETOR_ESTAGIARIO_FUNC()
RETURNS TRIGGER AS
$$
	BEGIN
		IF(TG_OP = 'UPDATE') THEN
            UPDATE setor SET id = new.id,
                            nome = new.nome,
                            orcamento = new.orcamento,
                            cnpj_empresa = new.cnpj_empresa
            WHERE id = OLD.id;
            IF NOT FOUND THEN RETURN NULL; END IF;

            NEW.last_updated = now();
            
            UPDATE estagiario SET id_setor = NEW.id		
            WHERE id_setor = OLD.id;
            RETURN NEW;
	
		ELSIF (TG_OP = 'DELETE') THEN
            DELETE FROM setor WHERE id = OLD.id;
            IF NOT FOUND THEN RETURN NULL; END IF;
		
			OLD.last_updated = now();
			
            DELETE FROM estagiario WHERE id_setor = OLD.id;
            IF NOT FOUND THEN RETURN NULL; END IF;
            return old;
		END IF;

	END;
$$
LANGUAGE 'plpgsql';




-- select * from empresa
-- select * from setor
-- empresa -> setor

CREATE OR REPLACE FUNCTION EMPRESA_SETOR_FUNC()
RETURNS TRIGGER AS
$$
	BEGIN
		IF(TG_OP = 'UPDATE') THEN
			UPDATE empresa SET orcamento = new.orcamento,
							  cnpj = new.cnpj,
							  nome = new.nome,
							  cpf_dono = new.cpf_dono
			WHERE cnpj = OLD.cnpj;
			IF NOT FOUND THEN RETURN NULL; END IF;

			NEW.last_updated = now();

			UPDATE setor SET cnpj_empresa = NEW.cnpj
			WHERE cnpj_empresa = OLD.cnpj;
			RETURN NEW;
	
		ELSIF (TG_OP = 'DELETE') THEN
            DELETE FROM empresa WHERE cnpj = OLD.cnpj;
            IF NOT FOUND THEN RETURN NULL; END IF;
		
			OLD.last_updated = now();
			
            DELETE FROM setor WHERE cnpj_empresa = OLD.cnpj;
			return old;
		END IF;

	END;
$$
LANGUAGE 'plpgsql';



-- select * from funcionario
-- select * from treina
-- funcionario -> treina

CREATE OR REPLACE FUNCTION FUNCIONARIO_TREINA_FUNC()
RETURNS TRIGGER AS
$$
	BEGIN
		IF(TG_OP = 'UPDATE') THEN
			UPDATE funcionario SET bonificacao = new.bonificacao,
							  cpf = new.cpf,
							  id_categoria = new.id_categoria,
							  id_setor = new.id_setor,
							  dia_pagamento = new.dia_pagamento,
							  data_inicio = new.data_inicio
			WHERE cpf = OLD.cpf;
			IF NOT FOUND THEN RETURN NULL; END IF;

			NEW.last_updated = now();

			UPDATE treina SET cpf_funcionario = NEW.cpf
			WHERE cpf_funcionario = OLD.cpf;
			RETURN NEW;
	
		ELSIF (TG_OP = 'DELETE') THEN
            DELETE FROM funcionario WHERE cpf = OLD.cpf;
            IF NOT FOUND THEN RETURN NULL; END IF;
		
			OLD.last_updated = now();
			
            DELETE FROM treina WHERE cpf_funcionario = OLD.cpf;
			return old;
		END IF;

	END;
$$
LANGUAGE 'plpgsql';




-- select * from funcionario
-- select * from gerente
-- funcionario -> gerente

CREATE OR REPLACE FUNCTION FUNCIONARIO_GERENTE_FUNC()
RETURNS TRIGGER AS
$$
	BEGIN
		IF(TG_OP = 'UPDATE') THEN
			
            UPDATE funcionario SET bonificacao = new.bonificacao,
							  cpf = new.cpf,
							  id_categoria = new.id_categoria,
							  id_setor = new.id_setor,
							  dia_pagamento = new.dia_pagamento,
							  data_inicio = new.data_inicio
			WHERE cpf = OLD.cpf;
			IF NOT FOUND THEN RETURN NULL; END IF;

			NEW.last_updated = now();

			UPDATE gerente SET cpf = NEW.cpf
			WHERE cpf = OLD.cpf;
			RETURN NEW;
	
		ELSIF (TG_OP = 'DELETE') THEN
            
            DELETE FROM funcionario WHERE cpf = OLD.cpf;
            IF NOT FOUND THEN RETURN NULL; END IF;
		
			OLD.last_updated = now();
			
            DELETE FROM gerente WHERE cpf = OLD.cpf;
			
			return old;
		END IF;

	END;
$$
LANGUAGE 'plpgsql';


--gerente -> gerencia
CREATE OR REPLACE FUNCTION GERENTE_GERENCIA_FUNC()
RETURNS TRIGGER AS
$$
	BEGIN
		IF(TG_OP = 'UPDATE') THEN
		
            UPDATE gerente SET bonificacao = new.bonificacao,
							  cpf = new.cpf,
							  id_categoria = new.id_categoria,
							  id_setor = new.id_setor,
							  dia_pagamento = new.dia_pagamento,
							  data_inicio = new.data_inicio
			WHERE cpf = OLD.cpf;
			IF NOT FOUND THEN RETURN NULL; END IF;

			NEW.last_updated = now();

			UPDATE gerencia SET cpf = NEW.cpf
			WHERE cpf = OLD.cpf;
			RETURN NEW;
	
		ELSIF (TG_OP = 'DELETE') THEN
            
            DELETE FROM funcionario WHERE cpf = OLD.cpf;
            IF NOT FOUND THEN RETURN NULL; END IF;
		
			OLD.last_updated = now();
			
            DELETE FROM gerencia WHERE cpf = OLD.cpf;
			
			return old;
		END IF;

	END;
$$
LANGUAGE 'plpgsql';



-- select * from estagiario
-- select * from treina
-- estagiario -> treina

CREATE OR REPLACE FUNCTION ESTAGIARIO_TREINA_FUNC()
RETURNS TRIGGER AS
$$
	BEGIN
		IF(TG_OP = 'UPDATE') THEN
			UPDATE estagiario SET cpf = new.cpf,
							  id_categoria = new.id_categoria,
							  id_setor = new.id_setor,
							  dia_pagamento = new.dia_pagamento,
							  inicio_estagio = new.inicio_estagio,
							  tempo_estagio = new.tempo_estagio
			WHERE cpf = OLD.cpf;
			IF NOT FOUND THEN RETURN NULL; END IF;

			NEW.last_updated = now();

			UPDATE treina SET cpf_estagiario = NEW.cpf
			WHERE cpf_estagiario = OLD.cpf;
			
            RETURN NEW;
	
		ELSIF (TG_OP = 'DELETE') THEN
            DELETE FROM estagiario WHERE cpf = OLD.cpf;
            IF NOT FOUND THEN RETURN NULL; END IF;
		
			OLD.last_updated = now();
			
            DELETE FROM treina WHERE cpf_estagiario = OLD.cpf;
            RETURN OLD;
		END IF;

	END;
$$
LANGUAGE 'plpgsql';






-- select * from estado
-- select * from cidade
-- estado -> cidade

CREATE OR REPLACE FUNCTION ESTADO_CIDADE_FUNC()
RETURNS TRIGGER AS
$$
	BEGIN
		IF(TG_OP = 'UPDATE') THEN
            UPDATE estado SET nome = new.nome,
							  uf = new.uf
			WHERE uf = OLD.uf;

			IF NOT FOUND THEN RETURN NULL; END IF;

			NEW.last_updated = now();

			UPDATE cidade SET uf = NEW.uf
			WHERE uf = OLD.uf;

			RETURN NEW;
		ELSIF (TG_OP = 'DELETE') THEN
            DELETE FROM estado WHERE uf = OLD.uf;
            IF NOT FOUND THEN RETURN NULL; END IF;
		
			OLD.last_updated = now();
			
            DELETE FROM cidade WHERE uf = OLD.uf;

            RETURN OLD;
        END IF;
		
	END;
$$
LANGUAGE 'plpgsql';



-- Pessoa -> log_interação
CREATE CONSTRAINT TRIGGER pessoa_log_interacao
after UPDATE OR DELETE ON Pessoa
DEFERRABLE INITIALLY DEFERRED
FOR EACH ROW EXECUTE PROCEDURE pessoa_log_interacao_func();



-- Pessoa -> estagiario
CREATE CONSTRAINT TRIGGER pessoa_estagiario
after UPDATE OR DELETE ON Pessoa
DEFERRABLE INITIALLY DEFERRED
FOR EACH ROW EXECUTE PROCEDURE pessoa_estagiario_func();



--Pessoa ->funcionario
CREATE CONSTRAINT TRIGGER pessoa_funcionario
after UPDATE OR DELETE ON Pessoa
DEFERRABLE INITIALLY DEFERRED
FOR EACH ROW EXECUTE PROCEDURE pessoa_funcionario_func();




-- Pessoa -> dono
CREATE CONSTRAINT TRIGGER pessoa_dono
after UPDATE OR DELETE ON Pessoa
DEFERRABLE INITIALLY DEFERRED
FOR EACH ROW EXECUTE PROCEDURE pessoa_dono_func();




-- Pessoa -> diretor
CREATE CONSTRAINT TRIGGER pessoa_diretor
after UPDATE OR DELETE ON Pessoa
DEFERRABLE INITIALLY DEFERRED
FOR EACH ROW EXECUTE PROCEDURE pessoa_diretor_func();




-- Pessoa -> endereco
CREATE CONSTRAINT TRIGGER pessoa_endereco
after UPDATE OR DELETE ON Pessoa
DEFERRABLE INITIALLY DEFERRED
FOR EACH ROW EXECUTE PROCEDURE pessoa_endereco_func();




-- categoria -> diretor
CREATE CONSTRAINT TRIGGER categoria_diretor
after UPDATE OR DELETE ON categoria
DEFERRABLE INITIALLY DEFERRED
FOR EACH ROW EXECUTE PROCEDURE categoria_diretor_func();





-- categoria -> estagiario
CREATE CONSTRAINT TRIGGER categoria_estagiario
after UPDATE OR DELETE ON categoria
DEFERRABLE INITIALLY DEFERRED
FOR EACH ROW EXECUTE PROCEDURE categoria_estagiario_func();




-- categoria -> funcionario
CREATE CONSTRAINT TRIGGER categoria_funcionario
after UPDATE OR DELETE ON categoria
DEFERRABLE INITIALLY DEFERRED
FOR EACH ROW EXECUTE PROCEDURE categoria_funcionario_func();




-- bairro -> endereco
CREATE CONSTRAINT TRIGGER bairro_endereco
after UPDATE OR DELETE ON bairro
DEFERRABLE INITIALLY DEFERRED
FOR EACH ROW EXECUTE PROCEDURE bairro_endereco_func();




-- cidade -> bairro
CREATE CONSTRAINT TRIGGER cidade_bairro
after UPDATE OR DELETE ON cidade
DEFERRABLE INITIALLY DEFERRED
FOR EACH ROW EXECUTE PROCEDURE cidade_bairro_func();




-- setor -> funcionario
CREATE CONSTRAINT TRIGGER setor_funcionario
after UPDATE OR DELETE ON setor
DEFERRABLE INITIALLY DEFERRED
FOR EACH ROW EXECUTE PROCEDURE setor_funcionario_func();
    



-- setor -> gerencia
CREATE CONSTRAINT TRIGGER SETOR_GERENCIA_FUNC
after UPDATE OR DELETE ON setor
DEFERRABLE INITIALLY DEFERRED
FOR EACH ROW EXECUTE PROCEDURE SETOR_GERENCIA_FUNC();



-- setor -> estagiario
CREATE CONSTRAINT TRIGGER SETOR_ESTAGIARIO_FUNC
after UPDATE OR DELETE ON setor
DEFERRABLE INITIALLY DEFERRED
FOR EACH ROW EXECUTE PROCEDURE SETOR_ESTAGIARIO_FUNC();




-- empresa -> setor
CREATE CONSTRAINT TRIGGER EMPRESA_SETOR
after UPDATE OR DELETE ON empresa
DEFERRABLE INITIALLY DEFERRED
DEFERRABLE INITIALLY DEFERRED
FOR EACH ROW EXECUTE PROCEDURE EMPRESA_SETOR_FUNC();




-- empresa -> categoria
CREATE CONSTRAINT TRIGGER empresa_categoria
after UPDATE OR DELETE ON empresa
DEFERRABLE INITIALLY DEFERRED
FOR EACH ROW EXECUTE PROCEDURE empresa_categoria_func();




-- funcionario -> treina
CREATE CONSTRAINT TRIGGER FUNCIONARIO_TREINA
after UPDATE OR DELETE ON funcionario
DEFERRABLE INITIALLY DEFERRED
FOR EACH ROW EXECUTE PROCEDURE FUNCIONARIO_TREINA_FUNC();




-- funcionario -> gerente
CREATE CONSTRAINT TRIGGER FUNCIONARIO_GERENTE
after UPDATE OR DELETE ON funcionario
DEFERRABLE INITIALLY DEFERRED
FOR EACH ROW EXECUTE PROCEDURE FUNCIONARIO_GERENTE_FUNC();




-- estagiario -> treina
CREATE CONSTRAINT TRIGGER ESTAGIARIO_TREINA
after UPDATE OR DELETE ON estagiario
DEFERRABLE INITIALLY DEFERRED
FOR EACH ROW EXECUTE PROCEDURE ESTAGIARIO_TREINA_FUNC();




-- estado -> cidade
CREATE CONSTRAINT TRIGGER ESTADO_CIDADE
after UPDATE OR DELETE ON estado
DEFERRABLE INITIALLY DEFERRED
FOR EACH ROW EXECUTE PROCEDURE ESTADO_CIDADE_FUNC();