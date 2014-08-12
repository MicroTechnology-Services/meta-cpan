DESCRIPTION = "Test::TCP is test utilities for TCP/IP programs."

SECTION = "libs"
LICENSE = "Artistic-1.0 | GPL-2.0"
PR = "r0"

MAINTAINER=	"Poky <poky@yoctoproject.org>"
HOMEPAGE=	"https://metacpan.org/release/Test-TCP"

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Artistic-1.0;md5=cda03bbdc3c1951996392b872397b798 \
file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "http://cpan.metacpan.org/authors/id/T/TO/TOKUHIROM/Test-TCP-2.06.tar.gz"

SRC_URI[md5sum] = "ab8f2025180c91eca7f7cbf90c3c7784"
SRC_URI[sha256sum] = "714956bb012536f617988e9cfb588253e908144e9169e5862356091f44e59229"
RDEPENDS_${PN} += "test-sharedfork-perl"
DEPENDS += "perl"

S = "${WORKDIR}/Test-TCP-${PV}"



inherit cpan

do_compile() {
	export LIBC="$(find ${STAGING_DIR_TARGET}/${base_libdir}/ -name 'libc-*.so')"
	cpan_do_compile
}

BBCLASSEXTEND = "native"
