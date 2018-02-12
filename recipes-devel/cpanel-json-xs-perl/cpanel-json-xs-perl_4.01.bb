DESCRIPTION = "This module converts Perl data structures to JSON and vice versa. Its \
primary goal is to be *correct* and its secondary goal is to be *fast*. To \
reach the latter goal it was written in C."

SECTION = "libs"
LICENSE = "Artisticv1 | GPLv1+"
PR = "r0"

MAINTAINER=	"Poky <poky@yoctoproject.org>"
HOMEPAGE=	"https://metacpan.org/release/Cpanel-JSON-XS"

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Artistic-1.0;md5=cda03bbdc3c1951996392b872397b798 \
file://${COMMON_LICENSE_DIR}/GPL-1.0;md5=e9e36a9de734199567a4d769498f743d"

SRC_URI = "https://cpan.metacpan.org/authors/id/R/RU/RURBAN/Cpanel-JSON-XS-4.01.tar.gz"

SRC_URI[md5sum] = "2fa675a43b270d16893807d5dc2bab07"
SRC_URI[sha256sum] = "c8cfd32a8a9508ab7f280452428582c3e46d0bed4ea863c3ec27c34f6920de60"

S = "${WORKDIR}/Cpanel-JSON-XS-${PV}"

inherit cpan

do_compile() {
	export LIBC="$(find ${STAGING_DIR_TARGET}/${base_libdir}/ -name 'libc-*.so')"
	cpan_do_compile
}

BBCLASSEXTEND = "native"
