package foundation.icon.icx.data;

import foundation.icon.icx.transport.jsonrpc.RpcObject;

import java.math.BigInteger;

public interface PrevVote {

    RpcObject getProperties();

    Address getRep();

    String getSignature();

    BigInteger getBlockHeight();

    BigInteger getTimeStamp();

    Bytes getBlockHash();
}
