OSDEP_DIR=../aircrack-ng/src/osdep

CC=gcc
NAME=aircrack-ng-jni
CFLAGS=-I$(JAVA_HOME)/include -I$(JAVA_HOME)/include/linux -I$(OSDEP_DIR) -I/usr/include/libnl3 -fPIC
LFLAGS=-L$(JAVA_HOME)/jre/bin/classic -L$(JAVA_HOME)/jre/bin -fPIC -ldl -shared -D_FILE_OFFSET_BITS=64
CFILES=org_tudelft_aircrack_JniInterface.c
OFILES=${CFILES:.c=.o}
LIBS=$(OSDEP_DIR)/libosdep.a

all: ${OFILES}
	${CC} ${LFLAGS} ${OFILES} ${LIBS} -o lib${NAME}.so

%o: %.c
	${CC} ${CFLAGS}

clean:
	rm -f lib${NAME}.so
	rm -f ${OFILES}