package communication;

public enum MessageType {

    ALERT{
        @Override
        public int code() {
            return -1;
        }
    },
    TEXT{
        @Override
        public int code() {
            return 0;
        }
    },
    IMAGE{
        @Override
        public int code() {
            return 1;
        }
    },
    VIDEO{
        @Override
        public int code() {
            return 2;
        }
    },
    RECORD{
        @Override
        public int code() {
            return 3;
        }
    },
    LOCATION{
        @Override
        public int code() {
            return 4;
        }
    },
    CONTACT{
        @Override
        public int code() {
            return 5;
        }
    },
    FILE{
        @Override
        public int code() {
            return 6;
        }
    },
    EXIT{
        @Override
        public int code() {
            return 7;
        }
    },
    DESTROY{
        @Override
        public int code() {
            return 8;
        }
    },
    INVITE{
        @Override
        public int code() {
            return 9;
        }
    },
    EXPEL{
        @Override
        public int code() {
            return 10;
        }
    };

    public abstract int code();

}