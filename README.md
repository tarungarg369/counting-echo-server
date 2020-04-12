# Counting echo server
Echo server is the companion server program. It listens for connection requests from clients on port 4444. (You can use any port from 1024 to 65,536; ports 0-1023 are reserved for "well-known" tasks, e.g., 80 for http, 21 for ftp). Upon receiving one, it establishes a connection, reads lines from the client, and echoes them back to the client.  

Counting Echo server is modified version of echo server which instead of echoes back the text from client it returns the occurence count for particular test input from client.

## Steps 
1. start server : java EchoServer &
2. start clients : jave EchoClient <clientname> server IP
3. Input any text in client terminal and 0 to close client connection 


