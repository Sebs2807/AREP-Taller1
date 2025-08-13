function saludar() {
    let name = document.getElementById("name").value;
    fetch("/api/hello?name=" + name)
        .then(resp => resp.json())
        .then(data => {
            document.getElementById("respuesta").innerText = data.message;
        });
}
