# Meta-rasptank Yocto Layer

## Description

This Yocto layer allows to build a custom Linux-based OS for [Adeept RaspTank robot](https://www.adeept.com/adeept-rasptank-wifi-wireless-smart-robot-car-kit-for-raspberry-pi-4-3-model-b-b-tank-tracked-robot-with-4-dof-robotic-arm-opencv-target-tracking_p0121.html) (RaspTank OS).

It comes with [example software](https://github.com/blkr35/Adeept_RaspTank) installed to control the robot. The robot is automatically configured on first boot.

## Supported targets
* Raspberry Pi 3B+
* Qemu

## Build

Fetch dependencies and meta-rasptank:
```
git clone -b dunfell git://git.yoctoproject.org/poky.git
git clone -b dunfell git://git.yoctoproject.org/meta-raspberrypi.git
git clone -b dunfell git://git.openembedded.org/meta-openembedded
git clone -b dunfell https://github.com/96boards/meta-96boards.git
git clone https://github.com/blkr35/meta-rasptank
```

Set up build environment:
```
source poky/oe-init-build-env
```
This will create and change directory to `./build`.

Add the Yocto layers to the project:
```
bitbake-layers add-layer ../meta-openembedded/meta-oe
bitbake-layers add-layer ../meta-openembedded/meta-python
bitbake-layers add-layer ../meta-openembedded/meta-multimedia
bitbake-layers add-layer ../meta-openembedded/meta-networking
bitbake-layers add-layer ../meta-raspberrypi
```

Create a local configuration file in `conf/local.conf` with the following content to specify the target:
```
# Select machine
MACHINE = "raspberrypi3-64"
# Distribution
DISTRO =  "rasptankos"
```

Finally, launch the build with:
```
bitbake rasptankos-image
```

## For developers

Instead of building and running for a physical device, you can also build for a virtual Qemu device.

Update the `conf/local.conf` file to specify:
```
# Select machine
MACHINE = "qemuarm64"
```

Then, run:
```
bitbake rasptankos-qemu
```

Run Qemu with:
```
runqemu
```
Then connect to 127.0.0.1:5900 using a VNC client.

As an alternative, you can also use SSH:
```
ssh root@192.168.7.2
```

## Deploy

Flash a microSD card for the Raspberry Pi (e.g. mounted as `/dev/sdb`):
```
sudo bmaptool copy tmp-glibc/deploy/images/raspberrypi3-64/rasptankos-image-raspberrypi3-64.wic.bz2 /dev/sdb
```

## On first boot

You will see the OS booting until the setup script asks for the name of your WiFi network and WPA2 password:
```
***********************************************
*                                             *
*             RaspTank software               *
*                                             *
***********************************************
Activate WiFi...
Add i2c-dev module...
Update/Installation of software requested...
***********************************************
Installing Adeept RaspTank Software Stack...
Configuring WiFi WPA2...
Enter network name (SSID):
mySSID
Enter password:
****
```
The device will then reboot multiple times to download and install the remaining dependencies.

## Connect

When the setup has completed, the device will display the following:
```
RaspTankOS (Linux Distribution for Adeept RaspTank robot) 1.0 rasptank tty1

IP address: <rasptankIP>

rasptank login:
```
Type `root`

### Using SSH
```
ssh root@<rasptankIP>
```

### Using webUI
You can access the web interface at `http://<rasptankIP>:5000`

## Release notes

| **RaspTank OS Version** | **Based on Yocto release* | **Comments** |
|-- |-- |-- |
| 1.0 | 3.1.25 "Dunfell" | Initial release |
