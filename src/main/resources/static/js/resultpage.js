$(document).ready(function () {
            $("#returnSorteio").click(function () {
                $.ajax({
                    type: "GET",
                    url: "/inicio",
                    success: function (data) {
                        window.document.write(data);
                        history.pushState(null, null, "/inicio");
                    },
                    error: function (data) {
                        alert("Falha na comunicação com o servidor");
                    }
                });
            });
        });