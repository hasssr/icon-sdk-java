package foundation.icon.icx.data;

import foundation.icon.icx.transport.jsonrpc.RpcObject;

import java.math.BigInteger;

public interface LeaderVote {

    RpcObject getProperties();

    Address getRep();

    BigInteger getTimeStamp();

    BigInteger getBlockHeight();

    Address getNewLeader();

    Address getOldLeader();

    String getSignature();
}
