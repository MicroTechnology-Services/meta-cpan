DESCRIPTION = "This module provides a way to return immediately from a deeply nested \
call stack. This is similar to exceptions, but exceptions don't stop \
automatically at a target frame (and they can be caught by intermediate \
stack frames). In other words, this is more like setjmp(3)/longjmp(3) \
than \
\"die\"."

SECTION = "libs"
LICENSE = "Artistic-1.0 | GPL-2.0"
PR = "r0"

MAINTAINER=	"Poky <poky@yoctoproject.org>"
HOMEPAGE=	"https://metacpan.org/release/Return-MultiLevel"

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Artistic-1.0;md5=cda03bbdc3c1951996392b872397b798 \
file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "http://cpan.metacpan.org/authors/id/M/MA/MAUKE/Return-MultiLevel-0.03.tar.gz"

SRC_URI[md5sum] = "810af063494c8a20b323f26a443657b2"
SRC_URI[sha256sum] = "b62a0a04a77578f878d8a57d568b74cdfc4a5ff7439e8620c7f90168566f96d4"

S = "${WORKDIR}/Return-MultiLevel-${PV}"



inherit cpan

do_compile() {
	export LIBC="$(find ${STAGING_DIR_TARGET}/${base_libdir}/ -name 'libc-*.so')"
	cpan_do_compile
}

BBCLASSEXTEND = "native"
