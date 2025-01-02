<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chatbot</title>
</head>
<body>
    <h1>Chatbot Interface</h1>
    <form id="chatForm">
        <input type="text" id="userInput" placeholder="Type your message here..." required>
        <button type="submit">Send</button>
    </form>
    <div id="chatResponse"></div>

    <script>
        document.getElementById('chatForm').onsubmit = function(event) {
            event.preventDefault();
            var userInput = document.getElementById('userInput').value;
            fetch('chatbot', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded',
                },
                body: 'userInput=' + encodeURIComponent(userInput)
            })
            .then(response => response.text())
            .then(data => {
                document.getElementById('chatResponse').innerHTML += '<p>' + data + '</p>';
                document.getElementById('userInput').value = '';
            });
        };
    </script>
</body>
</html>
