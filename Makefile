SHELL = /bin/sh
VERSION = 0.94
SRC_DIR = src
OSDEP_SRC_DIR = $(SRC_DIR)/c/aircrack-ng/src/osdep
JNI_SRC_DIR = $(SRC_DIR)/c/jni
WIFICRACK_SRC_DIR = $(SRC_DIR)/java
PACKAGE = com.etsy.net
PACKAGE_DIR = com/etsy/net
TEST_SOCKET_FILE = JUDS_TEST_SOCKET_FILE
CC = gcc
JAVAC = $(JAVA_HOME)/bin/javac
JAR = $(JAVA_HOME)/bin/jar
JAVAH = $(JAVA_HOME)/bin/javah
PLATFORM=linux
PREFIX = /usr
CFLAGS = -g -O2 -shared
JAVA_FLAGS = -g:none -deprecation -target 1.8
NATIVELIB=libosdep.a

M32=-m32
M64=-m64
JARFILE=juds-$(VERSION).jar
UNIJARFILE=juds-$(VERSION)-universal.jar


all: jar

jar: jni
	ant all

jni: osdep
	cd $(JNI_SRC_DIR) && $(MAKE)

osdep:
	cd $(OSDEP_SRC_DIR) && $(MAKE)

clean:
	cd $(JNI_SRC_DIR) && $(MAKE) clean
	cd $(OSDEP_SRC_DIR) && $(MAKE) clean
	-ant clean

