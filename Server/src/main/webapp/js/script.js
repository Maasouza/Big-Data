
window.onload = function () {
    init();
    checkboxHandler();
};


function init() {
    sumirDiv("idDivBusca");
    sumirDiv("idDivCatalogacao");
    sumirDiv("menuSair");
    sumirDiv("menuCatalogacao");
    sumirDiv("menuBusca");

    var btnEntrar = document.getElementById("menuEntrar");
    btnEntrar.addEventListener("click",
            function () {
                sumirDiv("idDivLogin");
                sumirDiv("menuBusca");
                aparecerDiv("idDivBusca");
                aparecerDiv("menuSair");
                aparecerDiv("menuCatalogacao");
            }
    );
    var btnSair = document.getElementById("menuSair");
    btnSair.addEventListener("click",
            function () {
                sumirDiv("idDivBusca");
                sumirDiv("idDivCatalogacao");
                sumirDiv("menuSair");
                sumirDiv("menuCatalogacao");
                sumirDiv("menuBusca");
                aparecerDiv("idDivLogin");
                if (!document.getElementById("iddatapublicacao3").readOnly) {
                    btnEditar.click();
                }

            }
    );
    var btnBusca = document.getElementById("menuBusca");
    btnBusca.addEventListener("click",
            function () {
                sumirDiv("idDivLogin");
                sumirDiv("menuBusca");
                sumirDiv("idDivCatalogacao");
                aparecerDiv("idDivBusca");
                aparecerDiv("menuSair");
                aparecerDiv("menuCatalogacao");
            }
    );
    var btnCatalogacao = document.getElementById("menuCatalogacao");
    btnCatalogacao.addEventListener("click",
            function () {
                sumirDiv("idDivLogin");
                sumirDiv("idDivBusca");
                sumirDiv("menuCatalogacao");
                aparecerDiv("idDivCatalogacao");
                aparecerDiv("menuSair");
                aparecerDiv("menuBusca");
            }
    );

    var btnBuscar = document.getElementById("idBuscar");
    btnBuscar.addEventListener("click", enviarJ);

    var btnEditar = document.getElementById("idEditar");
    btnEditar.addEventListener("click",
            function () {
                if (document.getElementById('iddatapublicacao3').readOnly) {
                    document.getElementById('iddatapublicacao3').readOnly = false;
                    document.getElementById('idEditar').className = "botaoEdit";
                } else {
                    if (!document.getElementById('iddatapublicacao3').readOnly) {
                        document.getElementById('iddatapublicacao3').readOnly = true;
                        document.getElementById('idEditar').className = "botoes";
                    }
                }
                if (document.getElementById('idtitulo3').readOnly) {
                    document.getElementById('idtitulo3').readOnly = false;
                    document.getElementById('idEditar').className = "botaoEdit";
                } else {
                    if (!document.getElementById('idtitulo3').readOnly) {
                        document.getElementById('idtitulo3').readOnly = true;
                        document.getElementById('idEditar').className = "botoes";
                    }
                }
                if (document.getElementById('idautoria3').readOnly) {
                    document.getElementById('idautoria3').readOnly = false;
                    document.getElementById('idEditar').className = "botaoEdit";
                } else {
                    if (!document.getElementById('idautoria3').readOnly) {
                        document.getElementById('idautoria3').readOnly = true;
                        document.getElementById('idEditar').className = "botoes";
                    }
                }
                if (document.getElementById('idveiculo3').readOnly) {
                    document.getElementById('idveiculo3').readOnly = false;
                    document.getElementById('idEditar').className = "botaoEdit";
                } else {
                    if (!document.getElementById('idveiculo3').readOnly) {
                        document.getElementById('idveiculo3').readOnly = true;
                        document.getElementById('idEditar').className = "botoes";
                    }
                }
                if (document.getElementById('idpalchave3').readOnly) {
                    document.getElementById('idpalchave3').readOnly = false;
                    document.getElementById('idEditar').className = "botaoEdit";
                } else {
                    if (!document.getElementById('idpalchave3').readOnly) {
                        document.getElementById('idpalchave3').readOnly = true;
                        document.getElementById('idEditar').className = "botoes";
                    }
                }
            }
    );

    var btnSalvar = document.getElementById("idSalvarAtual");
    btnSalvar.addEventListener("click", enviarA);

    var btnNovo = document.getElementById("idSalvarNovo");
    btnNovo.addEventListener("click", enviarC);

    var btnDownload = document.getElementById("idDownload");

    var btnExcluir = document.getElementById("idExcluir");
    btnExcluir.addEventListener("click", enviarD);

}

function sumirDiv(div) {
    document.getElementById(div).style.display = "none";
}

function aparecerDiv(div) {
    document.getElementById(div).style.display = "block";
}

function checkboxHandler() {
    var boxPatrimonio = document.getElementById("idcheckpatrimonio");
    var boxTituloOU = document.getElementById("idchecktituloOU");
    var boxTituloE = document.getElementById("idchecktituloE");
    var boxAutorOU = document.getElementById("idcheckautoriaOU");
    var boxAutorE = document.getElementById("idcheckautoriaE");
    var boxVeiculoOU = document.getElementById("idcheckveiculoOU");
    var boxVeiculoE = document.getElementById("idcheckveiculoE");
    var boxDataOU = document.getElementById("idcheckdatapublicacaoOU");
    var boxDataE = document.getElementById("idcheckdatapublicacaoE");
    var boxChaveOU = document.getElementById("idcheckpalchaveOU");
    var boxChaveE = document.getElementById("idcheckpalchaveE");
    boxPatrimonio.addEventListener("click",
            function () {
                if (boxPatrimonio.checked) {
                    boxTituloE.checked = false;
                    boxTituloOU.checked = false;
                    boxAutorE.checked = false;
                    boxAutorOU.checked = false;
                    boxVeiculoE.checked = false;
                    boxVeiculoOU.checked = false;
                    boxDataE.checked = false;
                    boxDataOU.checked = false;
                    boxChaveE.checked = false;
                    boxChaveOU.checked = false;
                }
            }
    );
    boxTituloOU.addEventListener("click",
            function () {
                if (boxTituloOU.checked) {
                    boxTituloE.checked = false;
                    boxPatrimonio.checked = false;
                }
            }
    );
    boxTituloE.addEventListener("click",
            function () {
                if (boxTituloE.checked) {
                    boxTituloOU.checked = false;
                    boxPatrimonio.checked = false;
                }
            }
    );
    boxAutorOU.addEventListener("click",
            function () {
                if (boxAutorOU.checked) {
                    boxAutorE.checked = false;
                    boxPatrimonio.checked = false;
                }
            }
    );
    boxAutorE.addEventListener("click",
            function () {
                if (boxAutorE.checked) {
                    boxAutorOU.checked = false;
                    boxPatrimonio.checked = false;
                }
            }
    );
    boxVeiculoOU.addEventListener("click",
            function () {
                if (boxVeiculoOU.checked) {
                    boxVeiculoE.checked = false;
                    boxPatrimonio.checked = false;
                }
            }
    );
    boxVeiculoE.addEventListener("click",
            function () {
                if (boxVeiculoE.checked) {
                    boxVeiculoOU.checked = false;
                    boxPatrimonio.checked = false;
                }
            }
    );
    boxDataOU.addEventListener("click",
            function () {
                if (boxDataOU.checked) {
                    boxDataE.checked = false;
                    boxPatrimonio.checked = false;
                }
            }
    );
    boxDataE.addEventListener("click",
            function () {
                if (boxDataE.checked) {
                    boxDataOU.checked = false;
                    boxPatrimonio.checked = false;
                }
            }
    );
    boxChaveOU.addEventListener("click",
            function () {
                if (boxChaveOU.checked) {
                    boxChaveE.checked = false;
                    boxPatrimonio.checked = false;
                }
            }
    );
    boxChaveE.addEventListener("click",
            function () {
                if (boxChaveE.checked) {
                    boxChaveOU.checked = false;
                    boxPatrimonio.checked = false;
                }
            }
    );

}


function enviarJ() { //buscar
    var boxPatrimonio = document.getElementById("idcheckpatrimonio");
    var boxTituloOU = document.getElementById("idchecktituloOU");
    var boxTituloE = document.getElementById("idchecktituloE");
    var boxAutorOU = document.getElementById("idcheckautoriaOU");
    var boxAutorE = document.getElementById("idcheckautoriaE");
    var boxVeiculoOU = document.getElementById("idcheckveiculoOU");
    var boxVeiculoE = document.getElementById("idcheckveiculoE");
    var boxDataOU = document.getElementById("idcheckdatapublicacaoOU");
    var boxDataE = document.getElementById("idcheckdatapublicacaoE");
    var boxChaveOU = document.getElementById("idcheckpalchaveOU");
    var boxChaveE = document.getElementById("idcheckpalchaveE");

    var sendData = {};
    sendData['tipo'] = "busca";
    sendData['tipoTitulo'] = "";
    sendData['tipoAutor'] = "";
    sendData['tipoVeiculo'] = "";
    sendData['tipoData'] = "";
    sendData['tipoChave'] = "";
    sendData['usarPatrimonio'] = 0;

    sendData['titulo'] = document.getElementById('idtitulo2').value;
    sendData['patrimonio'] = document.getElementById('idpatrimonio2').value;
    sendData['autoria'] = document.getElementById('idautoria2').value;
    sendData['veiculo'] = document.getElementById('idveiculo2').value;
    sendData['dataI'] = document.getElementById('iddatapublicacao21').value;
    sendData['dataF'] = document.getElementById('iddatapublicacao22').value;
    sendData['chave'] = document.getElementById('idpalchave2').value;

    if (boxPatrimonio.checked) {
        sendData['usarPatrimonio'] = 1;
    }
    if (boxTituloE.checked) {
        sendData['tipoTitulo'] = "E";
    } else {
        if (boxTituloOU.checked) {
            sendData['tipoTitulo'] = "OU";
        }
    }

    if (boxAutorE.checked) {
        sendData['tipoAutor'] = "E";
    } else {
        if (boxAutorOU.checked) {
            sendData['tipoAutor'] = "OU";
        }
    }

    if (boxVeiculoE.checked) {
        sendData['tipoVeiculo'] = "E";
    } else {
        if (boxVeiculoOU.checked) {
            sendData['tipoVeiculo'] = "OU";
        }
    }
    if (boxDataE.checked) {
        sendData['tipoData'] = "E";

    } else {
        if (boxDataOU.checked) {
            sendData['tipoData'] = "OU";
        }
    }
    if (boxChaveE.checked) {
        sendData['tipoChave'] = "E";
    } else {
        if (boxChaveOU.checked) {
            sendData['tipoChave'] = "OU";
        }
    }


    pedidoAJAX(sendData, popularCamposComJSON);
}
;

var referencias;
function cat(pos) {
    sumirDiv("idDivLogin");
    sumirDiv("idDivBusca");
    sumirDiv("menuCatalogacao");
    aparecerDiv("idDivCatalogacao");
    aparecerDiv("menuSair");
    aparecerDiv("menuBusca");
    document.getElementById('idtitulo3').value = referencias[pos].titulo;
    document.getElementById('idautoria3').value = referencias[pos].autoria;
    document.getElementById('idveiculo3').value = referencias[pos].veiculo;
    document.getElementById('idpatrimonio3').value = referencias[pos].patrimonio;

}

function popularCamposComJSON(objJSONresp) {
    referencias = objJSONresp;
    document.getElementById("idTabelaResultados").innerHTML = "";
    for (i = 0; i < objJSONresp.length; i++) {
        document.getElementById("idTabelaResultados").innerHTML += "" +
                "Título: " + objJSONresp[i].titulo +
                "<br>Autor: " + objJSONresp[i].autoria +
                "<br>Veículo: " + objJSONresp[i].veiculo +
                "<br><input type='button' onclick='cat(" + i + ")' value='Editar'/><hr>";
    }

}
;

function enviarC() { //criar
    var sendData = {};
    sendData['tipo'] = "inserir";
    sendData['titulo'] = document.getElementById('idtitulo3').value;
    sendData['autoria'] = document.getElementById('idautoria3').value;
    sendData['veiculo'] = document.getElementById('idveiculo3').value;
    sendData['data'] = document.getElementById('iddatapublicacao3').value;
    sendData['chave'] = document.getElementById('idpalchave3').value;

    pedidoAJAX(sendData, receberID);
}

function receberID(res){
    document.getElementById("idpatrimonio3").value=res.resultado;
}

function alertaAlt(){
    alert("Alterado");
}

function aletarDel(){
    alert("Excluído");
}

function enviarA(){  //alteração
    var sendData = {};
    sendData['titulo'] = document.getElementById('idtitulo3').value;
    sendData['autoria'] = document.getElementById('idautoria3').value;
    sendData['veiculo'] = document.getElementById('idveiculo3').value;
    sendData['data'] = document.getElementById('iddatapublicacao3').value;
    sendData['chave'] = document.getElementById('idpalchave3').value;
    sendData['parametro'] = document.getElementById('idpatrimonio3').value;
    
    pedidoAJAX(sendData, alertaAlt);
    alert("Alterado");
}

function enviarD(){ //excluir
    var sendData = {};
    sendData['parametro'] = document.getElementById('idpatrimonio3').value;
    
    pedidoAJAX(sendData, aletarDel);
}


function pedidoAJAX(objetoJSON, funcPopularPagina) {
    var stringJSON = JSON.stringify(objetoJSON);
    var objPedidoAJAX = new XMLHttpRequest();
    objPedidoAJAX.open("POST", "controller");
    objPedidoAJAX.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    // Prepara recebimento da resposta: tipo da resposta JSON!
    objPedidoAJAX.responseType = 'json';
    objPedidoAJAX.onreadystatechange =
            function () {
                if (objPedidoAJAX.readyState === 4 && objPedidoAJAX.status === 200) {
                    // A resposta 'response' já é avaliada para json!
                    // Ao contraro da resposta responseText.
                    funcPopularPagina(objPedidoAJAX.response);
                }
            };
    // Envio do pedido
    objPedidoAJAX.send(stringJSON);
}
;

