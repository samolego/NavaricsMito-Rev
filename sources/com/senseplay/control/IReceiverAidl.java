package com.senseplay.control;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.senseplay.control.IKeyAid;
import com.senseplay.control.IRJoyStickAidl;
import com.senseplay.control.IRVechileAidl;

/* loaded from: classes2.dex */
public interface IReceiverAidl extends IInterface {
    IRJoyStickAidl getJoyStockAidl() throws RemoteException;

    IKeyAid getKeyAidl() throws RemoteException;

    IRVechileAidl getVechileAidl() throws RemoteException;

    /* loaded from: classes2.dex */
    public static abstract class Stub extends Binder implements IReceiverAidl {
        private static final String DESCRIPTOR = "com.senseplay.control.IReceiverAidl";
        static final int TRANSACTION_getJoyStockAidl = 1;
        static final int TRANSACTION_getKeyAidl = 3;
        static final int TRANSACTION_getVechileAidl = 2;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IReceiverAidl asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IReceiverAidl)) {
                return (IReceiverAidl) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
                    IRJoyStickAidl joyStockAidl = getJoyStockAidl();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(joyStockAidl != null ? joyStockAidl.asBinder() : null);
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    IRVechileAidl vechileAidl = getVechileAidl();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(vechileAidl != null ? vechileAidl.asBinder() : null);
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    IKeyAid keyAidl = getKeyAidl();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(keyAidl != null ? keyAidl.asBinder() : null);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* loaded from: classes2.dex */
        private static class Proxy implements IReceiverAidl {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.senseplay.control.IReceiverAidl
            public IRJoyStickAidl getJoyStockAidl() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return IRJoyStickAidl.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.senseplay.control.IReceiverAidl
            public IRVechileAidl getVechileAidl() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return IRVechileAidl.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.senseplay.control.IReceiverAidl
            public IKeyAid getKeyAidl() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return IKeyAid.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
