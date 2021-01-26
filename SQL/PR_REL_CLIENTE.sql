CREATE OR REPLACE PROCEDURE SYSTEM.PR_REL_CLIENTE
( P_indentificador  IN varchar2, 
  p_ret              OUT sys_refcursor)
IS
BEGIN
	dbms_output.put_line(P_indentificador);
	 OPEN p_ret FOR 
	 	SELECT 
		tc.DAT_CADASTRO , te.TIPO_ENDERECO , te.RUA, te.BAIRRO ,te.NUMERO, te.COMPLEMENTO , te.CIDADE , te.CEP ,
				 TM.TIPO_MOVIMENTACAO, 
				 count(tm.VALOR) qtde,
				 sum( CASE WHEN TM.TIPO_MOVIMENTACAO = 'credito' THEN tm.VALOR ELSE 0 END ) + sum( CASE WHEN TM.TIPO_MOVIMENTACAO = 'debito' THEN tm.VALOR * -1 ELSE 0 END ) total,
				 CASE --count(tm.VALOR)
				 	  WHEN count(tm.VALOR) < 4 THEN count(tm.VALOR) * 1
				      WHEN count(tm.VALOR) > 3  AND count(tm.VALOR) < 10  THEN 200 
				      ELSE count(tm.VALOR) * 10  END valor
		FROM TB_CLIENTE tc,
			TB_ENDERECO te ,
			TB_MOVIMENTACAO tm 
		WHERE te.CLIENTE_ID = tc.ID 
		AND tc.ID  = tm.CLIENTE_ID 
		AND te.TIPO_ENDERECO = 'COM'
		AND IDENTIFICADOR = P_indentificador
		GROUP BY  (tc.DAT_CADASTRO , te.TIPO_ENDERECO , te.RUA, te.BAIRRO ,te.NUMERO, te.COMPLEMENTO , te.CIDADE , te.CEP, TM.TIPO_MOVIMENTACAO )  ;

	dbms_output.put_line('fim');

END PR_REL_CLIENTE;
