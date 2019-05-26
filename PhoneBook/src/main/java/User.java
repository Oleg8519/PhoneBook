public class User {

        private int iduser;
        private String name;
        private String surname;
        private int phoneNumber;

        public User() {
        }

        public User(int iduser, String name, String surname, int phoneNumber) {
            this.iduser = iduser;
            this.name = name;
            this.surname = surname;
            this.phoneNumber = phoneNumber;
        }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
        public String toString() {
            return getClass().getSimpleName() + "{ iduser: "+iduser+", name: "+ name +", surname: "+surname+", phoneNumber: "+ phoneNumber +"}";
        }
    }
