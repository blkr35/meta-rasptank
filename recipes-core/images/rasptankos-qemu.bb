SUMMARY = "RaspTank OS image"

LICENSE = "MIT"

COMPATIBLE_MACHINE = '(qemuarm64)'

inherit core-image

# add features
EXTRA_IMAGE_FEATURES_append = " ssh-server-dropbear"
EXTRA_IMAGE_FEATURES_append = " debug-tweaks"

MACHINE_FEATURES_append = " vc4graphics"

# necessary software
CORE_IMAGE_EXTRA_INSTALL_append = " psplash"
CORE_IMAGE_EXTRA_INSTALL_append = " vim"
CORE_IMAGE_EXTRA_INSTALL_append = " git"
CORE_IMAGE_EXTRA_INSTALL_append = " python3 python3-dev python3-pip python3-smbus"
CORE_IMAGE_EXTRA_INSTALL_append = " freetype libjpeg-turbo gcc packagegroup-core-buildessential"
CORE_IMAGE_EXTRA_INSTALL_append = " i2c-tools jasper gstreamer1.0"
# or "atlas" ?
CORE_IMAGE_EXTRA_INSTALL_append = " hdf5"
CORE_IMAGE_EXTRA_INSTALL_append = " util-linux procps hostapd iproute2 iw haveged dnsmasq"
# Other python modules
CORE_IMAGE_EXTRA_INSTALL_append = " python3-luma-oled python3-flask python3-websockets python3-psutil python3-pyusb python3-pyserial"
CORE_IMAGE_EXTRA_INSTALL_append = " python3-pillow python3-numpy"
#
CORE_IMAGE_EXTRA_INSTALL_append = " rasptank"

QB_KERNEL_CMDLINE_APPEND = "console=ttyS0"

