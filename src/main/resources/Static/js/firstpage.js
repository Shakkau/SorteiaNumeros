$(document).ready(function () {
        $("#btnSortear").click(function () {
            let quantityN = $("#quantity").val();
            let minN = $("#minNumber").val();
            let maxN = $("#maxNumber").val();

            $.ajax({
                type: "POST",
                url: "/paginaResultado",
                data: { quantityNumbers: quantityN,
                        minNumber: minN,
                        maxNumber: maxN,
                        },
                success: function (data) {
                    window.document.write(data);
                    history.pushState(null, null, "/paginaResultado");
                },
                error: function (data) {
                    alert("Falha na comunicação com o servidor");
                }
            });
        });
    });