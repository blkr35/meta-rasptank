SUMMARY = "RaspTank OS image"

LICENSE = "MIT"

COMPATIBLE_MACHINE = '(raspberrypi3-64)'

inherit core-image

# distro features
DISTRO_FEATURES_append = " x11 fbdev directfb opengl"
DISTRO_FEATURES_remove = " wayland vulkan"

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

# Image size will be extended to fill up the sdcard
CORE_IMAGE_EXTRA_INSTALL_append = " 96boards-tools"

# Enable options at boot 
ENABLE_I2C = "1"
KERNEL_MODULE_AUTOLOAD_rpi += " i2c-dev i2c-bcm2708"
VIDEO_CAMERA = "1"

