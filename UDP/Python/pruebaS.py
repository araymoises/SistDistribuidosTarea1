import socket

UDP_IP = "localhost"
UDP_PORT = 9876
MESSAGE = "Hola soy Python me reporto"
BYTE = 1024

sock = socket.socket(socket.AF_INET, # Internet
                    socket.SOCK_DGRAM) # UDP
sock.bind((UDP_IP, UDP_PORT))
# ENVIO MENSAJE
sock.sendto(MESSAGE, (UDP_IP, 9877))
#while True:
# RESPUESTA DEL CLIENTE
data, addr = sock.recvfrom(1024) # buffer size is 1024 bytes
print "Client: ", data
sock.close()