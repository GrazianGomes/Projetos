/**
 * Validação de formulário
* @author Grazian Gomes
 */

function validar() {
	let nome = frmContato.nome.value
	let fone = frmContato.fone.value
	if (nome === "") {
		alert('Prencha o campo Nome')
		frmContato.nome.focus()
		return false
	} else if (fone === "") {
		alert('Prencha o campo fone')
		frmContato.fone.focus()
		return false
	} else{
		document.forms["frmContato"].submit()
	}

}