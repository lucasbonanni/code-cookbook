# How to Create Custom Vagrant Boxes

Follow these steps to create your custom Vagrant box:

1. **Create a Virtual Machine (VM)**

   - Set the desired disk size and memory for the template.
   - During installation, specify the default language, location, and hostname.
   - Set the root password to 'vagrant'.
   - Create a new user 'vagrant' (all lowercase) with the password 'vagrant'. This user is essential for Vagrant.
   - Install the SSH server.
   - Install the GRUB menu.

2. **Reboot the VM**

3. **Configure and Customize**

4. **Ensure Sudo is Installed**

5. **Create a Sudoers File**

   - Run `visudo -f /etc/sudoers.d/vagrant.tmp` and add the following line:

   ```
   vagrant ALL=(root) NOPASSWD: ALL
   ```

6. **Add Vagrant User to Sudo Group**

   - Run the command: `usermod -aG sudo vagrant`

7. *[Optional]* **Set Editor as Vim**

8. **Switch to the Vagrant User**

   - Execute the following:

   ```sh
   su - vagrant
   mkdir -m 700 .ssh
   wget -O .ssh/authorized_keys https://raw.githubusercontent.com/hashicorp/vagrant/master/keys/vagrant.pub
   cat .ssh/authorized_keys # (to check the key)
   chmod 600 .ssh/authorized_keys # (to set proper file permissions)
   history -c # (to clean the history)
   exit # (to return to root)
   ```

9. **Install Required Packages**

   - For Debian (adjust for other distributions):

   ```sh
   apt install -y dkms linux-headers-$(uname -r) build-essential
   ```

10. **Power Off or Reboot the VM**

11. **Obtain the Latest Guest Additions ISO**

12. **Log in as the Root User**

13. **Mount Guest Additions**

    - Execute the following:

    ```sh
    mount /dev/cdrom /mnt
    /mnt/VBoxLinuxAdditions.run
    ```

14. **Power Off the VM**

15. **Create a Directory**

    - Example: `mkdir debian12` and navigate to the directory.

16. **Export the Virtual Machine as a Box**

    - Run:

    ```sh
    vagrant package --base debian12 --output debian12.box
    ```

17. **Add the Vagrant Box Locally**

    - Use the following command:

    ```sh
    vagrant box add debian12 debian12.box
    ```

18. **Remove the Box File Created in Step 16**

    - You can delete `debian12.box`.

19. **Verify the Vagrant Box**

    - Confirm that the Vagrant box is available:

    ```sh
    vagrant box list
    ```

By following these steps, you'll have successfully created a custom Vagrant box based on your configured VM, ready to use in your Vagrant projects.



## Links
[Custom vagrant box - Urban penguin](https://youtu.be/Wqtlj9osK0g)