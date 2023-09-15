$(document).ready(function () {
        $("#btnSortear").click(function () {
            let quantityN = $("#quantity").val();
            let minN = $("#minNumber").val();
            let maxN = $("#maxNumber").val();
            let checkedBox = $("#chk-order-by")[0].checked;
            let checkedBox2 = $("#chk-repeat-result")[0].checked;

            $.ajax({
                type: "POST",
                url: "/paginaResultado",
                data: { quantityNumbers: quantityN,
                        minNumber: minN,
                        maxNumber: maxN,
                        checkBox: checkedBox,
                        checkBox2: checkedBox2,
                        },
                success: function (data) {
                    $("body").html(data);
                    history.pushState(null, null, "/paginaResultado");
                },
                error: function (data) {
                    alert("Falha na comunicação com o servidor");
                }
            });
        });
    });