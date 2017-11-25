import socket

UDP_IP = "192.168.0.106"
UDP_PORT = 9876
BYTE = 1024000

sock = socket.socket(socket.AF_INET, # Internet
                    socket.SOCK_DGRAM) # UDP
#sock.settimeout(60)
sock.bind((UDP_IP, UDP_PORT))
# ENVIO MENSAJE
#sock.sendto(MESSAGE, (UDP_IP, 9876))
while True:
	print '\nEsperando recibir mensaje'
	data, address = sock.recvfrom(BYTE)
	print 'Recibi %s bytes de %s' % (len(data), address)
	if data:
		print 'Contenido del mensaje:\n%s' % data
		MESSAGE = 'Recibi %s bytes' % len(data)
		sent = sock.sendto(MESSAGE, address)
# RESPUESTA DEL CLIENTE
#data, addr = sock.recvfrom(1024) # buffer size is 1024 bytes
#print "Client: ", data
sock.close()