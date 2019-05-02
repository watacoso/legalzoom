$(document).ready(function() {

    console.log("ready");


        var singleInsertForm = document.getElementById('singleinsert');
    singleInsertForm.addEventListener('submit', function(event) {
            console.log("submit");
                if (singleInsertForm.checkValidity() === false) {
                    console.log("fail");
                    event.preventDefault();
                    event.stopPropagation();
                }
            singleInsertForm.classList.add('was-validated');
            }, false);

})
