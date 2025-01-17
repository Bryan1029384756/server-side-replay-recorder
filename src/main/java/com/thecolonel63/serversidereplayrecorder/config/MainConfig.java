package com.thecolonel63.serversidereplayrecorder.config;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class MainConfig {

    public int command_op_level = 4;
    private File replay_folder_name = new File("replay_recordings");
    private boolean use_username_for_recordings = true;
    private String server_name = "My Server";
    private Set<String> recordable_users = new HashSet<>();
    private boolean invert_user_list = false;
    private boolean recording_enabled = false;
    private boolean use_server_timestamps = true;
    private boolean assume_unloaded_chunks_dont_change = true;
    private boolean render_distance_fog_fix = false;
    private long  max_file_size = 10000000000L;
    private int voice_recording_range = 48;
    private boolean voice_recording_enabled = false;
    private URL file_storage_url;
    private boolean debug = false;

    public MainConfig() {
        try {
            file_storage_url = new URL("https://file.io/");
        } catch (Throwable ignored) {
        }
    }

    public boolean isAssume_unloaded_chunks_dont_change() {
        return assume_unloaded_chunks_dont_change;
    }

    public void setAssume_unloaded_chunks_dont_change(boolean assume_unloaded_chunks_dont_change) {
        this.assume_unloaded_chunks_dont_change = assume_unloaded_chunks_dont_change;
    }

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public int getVoice_recording_range() {
        return voice_recording_range;
    }

    public void setVoice_recording_range(int voice_recording_range) {
        this.voice_recording_range = voice_recording_range;
    }

    public boolean isVoice_recording_enabled() {
        return voice_recording_enabled;
    }

    public void setVoice_recording_enabled(boolean voice_recording_enabled) {
        this.voice_recording_enabled = voice_recording_enabled;
    }

    public long getMax_file_size() {

        return max_file_size;
    }

    public void setMax_file_size(long max_file_size) {
        this.max_file_size = max_file_size;
    }

    @JsonProperty(value = "use_server_timestamps")
    public boolean use_server_timestamps() {
        return use_server_timestamps;
    }

    public void setUse_server_timestamps(boolean use_server_timestamps) {
        this.use_server_timestamps = use_server_timestamps;
    }

    public URL getFile_storage_url() {
        return file_storage_url;
    }

    @JsonProperty(value = "file_storage_url")
    public void setFile_storage_url(String file_storage_url) throws MalformedURLException {
        this.file_storage_url = new URL(file_storage_url);
    }

    public int getCommand_op_level() {
        return command_op_level;
    }

    public void setCommand_op_level(int command_op_level) {
        this.command_op_level = command_op_level;
    }

    public boolean isRecording_enabled() {
        return recording_enabled;
    }

    public void setRecording_enabled(boolean recording_enabled) {
        this.recording_enabled = recording_enabled;
    }

    public String getReplay_folder_name() {
        return replay_folder_name.getName();
    }

    public void setReplay_folder_name(String replay_folder_name) {
        this.replay_folder_name = new File(replay_folder_name);
    }

    @JsonProperty(value = "use_username_for_recordings")
    public boolean use_username_for_recordings() {
        return use_username_for_recordings;
    }

    public void setUse_username_for_recordings(boolean use_username_for_recordings) {
        this.use_username_for_recordings = use_username_for_recordings;
    }

    public String getServer_name() {
        return server_name;
    }

    public void setServer_name(String server_name) {
        this.server_name = server_name;
    }

    public Set<String> getRecordable_users() {
        return this.recordable_users;
    }

    public void setRecordable_users(Set<String> recordable_users) {
        this.recordable_users = recordable_users;
    }

    @JsonProperty(value = "invert_user_list")
    public boolean invert_user_list() {
        return invert_user_list;
    }

    public void setInvert_user_list(boolean invert_user_list) {
        this.invert_user_list = invert_user_list;
    }

    @JsonProperty(value = "render_distance_fog_fix")
    public boolean render_distance_fog_fix() {
        return render_distance_fog_fix;
    }

    public void setRender_distance_fog_fix(boolean render_distance_fog_fix) {
        this.render_distance_fog_fix = render_distance_fog_fix;
    }
}
