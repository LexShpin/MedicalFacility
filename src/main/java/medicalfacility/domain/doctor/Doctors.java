package medicalfacility.domain.doctor;

public enum Doctors {
    THERAPIST {
        @Override
        public String toString() {
            return "Therapist";
        }
    },
    CARDIOLOGIST {
        @Override
        public String toString() {
            return "Cardiologist";
        }
    },
    GASTROENTEROLOGIST {
        @Override
        public String toString() {
            return "Gastroenterologist";
        }
    }
}
