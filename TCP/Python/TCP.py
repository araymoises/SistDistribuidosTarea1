#!/usr/bin/env python
import socket

TCP_IP = '192.168.0.106'
TCP_PORT = 9877
BUFFER_SIZE = 20  # Normally 1024, but we want fast response

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.bind((TCP_IP, TCP_PORT))
s.listen(5)
print 'Esperando conexiones...'
conn, addr = s.accept()
print 'Conexiones address:', addr
while 1:
	data = conn.recv()
	if data: break
	print "recibi data:", data
	conn.send(data)  # echo
conn.close()