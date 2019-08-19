package foundation.icon.icx.data;

import foundation.icon.icx.transport.jsonrpc.RpcItem;
import foundation.icon.icx.transport.jsonrpc.RpcObject;

import java.math.BigInteger;

public class ConfirmedPrevVote implements PrevVote {

    private RpcObject properties;

    ConfirmedPrevVote(RpcObject properties) {
        this.properties = properties;
    }

    @Override
    public RpcObject getProperties() {
        return properties;
    }

    @Override
    public Address getRep() {
        RpcItem item = properties.getItem("rep");
        return item != null ? item.asAddress() : null;
    }

    @Override
    public String getSignature() {
        RpcItem item = properties.getItem("signature");
        return item != null ? item.asString() : null;
    }

    @Override
    public BigInteger getBlockHeight() {
        RpcItem item = properties.getItem("blockHeight");
        return item != null ? item.asInteger() : null;
    }

    @Override
    public BigInteger getTimeStamp() {
        RpcItem item = properties.getItem("timestamp");
        return item != null ? item.asInteger() : null;
    }

    @Override
    public Bytes getBlockHash() {
        RpcItem item = properties.getItem("blockHash");
        return item != null ? item.asBytes() : null;
    }

    @Override
    public String toString() {
        return "ConfirmedPrevVote{" +
                "properties=" + properties +
                '}';
    }

}
