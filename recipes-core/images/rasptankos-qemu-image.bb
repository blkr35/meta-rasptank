# Base this image on raspbtankos-base-image.bb
require recipes-core/images/rasptankos-base-image.bb

LICENSE = "MIT"

COMPATIBLE_MACHINE = '(qemuarm64)'

QB_KERNEL_CMDLINE_APPEND = "console=ttyS0"

