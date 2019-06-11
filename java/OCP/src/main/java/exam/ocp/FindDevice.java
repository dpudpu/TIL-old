//package exam.ocp;
//
//public class FindDevice {
//    public String FindDevice(DeviceModel model) {
//        SerialPort port = new SerialPort();
//        switch (model) {
//            case DeviceModel.BillAccepterCashCode: {
//                port.BaudRate = 9600;
//            }
//            case DeviceModel.BillDispenserEcdm: {
//                port.BaudRate = 4800;
//            }
//            case DeviceModel.CoinAccepterNri: {
//                port.BaudRate = 19200;
//            }
//            case DeviceModel.CoinDispenserCube4: {
//                port.BaudRate = 9600;
//            }
//            case DeviceModel.CoinDispsenerSch2: {
//                port.BaudRate = 4800;
//            }
//            default:
//                throw new ArgumentException("Unknown model: {model}.");
//        }
//        return Find(port);
//    }
//}
