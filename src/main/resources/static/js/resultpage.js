$(document).ready(function () {
            $("#returnSorteio").click(function () {
                $.ajax({
                    type: "GET",
                    url: "/inicio",
                    success: function () {
                        window.location.href = "/inicio";
                    },
                    error: function () {
                        alert("Falha na comunicação com o servidor");
                    }
                });
            });
        });