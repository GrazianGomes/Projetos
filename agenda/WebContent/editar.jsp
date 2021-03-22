<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
    <%
    //recebimento do conteudo javaBeans
    String id = (String) request.getAttribute("id");
    String nome = (String) request.getAttribute("nome");
    String fone = (String) request.getAttribute("fone");
    String email = (String) request.getAttribute("email");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="styLesheet" href="style.css">
<title>Agenda de Contatos</title>
</head>
<body>
	<h1>Editar um Contato</h1>
	<form name="frmContato" action="update2">
		<table>
		<tr>
		    <td><input type="text" name = "id" value="<%=id%>"readonly class="Caixa2" ></td>
		</tr>
			<tr>
				<td><input type="text" name="nome" value="<%=nome%>" class="Caixa1"></td>
			</tr>
			<tr>
				<td><input type="text" name="fone" value="<%=fone%>"
					class="Caixa2"></td>
			</tr>
			<tr>
				<td><input type="text" name="email" value="<%=email%>"
					class="Caixa1"></td>
			</tr>
		</table>
		<input type="button" value="Salvar" class="Botao1" onclick="validar()">
	</form>
	<script src="scripts/validador.js"></script>
</body>
</html>